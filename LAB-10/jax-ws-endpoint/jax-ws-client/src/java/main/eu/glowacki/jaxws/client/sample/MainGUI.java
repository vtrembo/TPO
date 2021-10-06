package eu.glowacki.jaxws.client.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.sample.proxy.CalculatorImplService;
import eu.glowacki.jaxws.client.sample.proxy.ICalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public final class MainGUI extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 465320630720463494L;

    private static final Random RANDOM = new Random();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) {
        try {
            new MainGUI();
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
    }

    private final ICalculator _proxy;

    private final JButton _btnAdd;
    private final JTextArea _txtOutput;
    private final JScrollPane _scroll;

    private MainGUI() throws MalformedURLException {
        _proxy = proxyImpl();
        _btnAdd = new JButton("EchoMessage");
        _btnAdd.addActionListener(this);
        _txtOutput = new JTextArea(20, 0);
        _scroll = new JScrollPane(_txtOutput);
        layoutImpl();
        setVisible(true);
    }

    private static ICalculator proxyImpl() throws MalformedURLException {
        URL wsdl = new URL(eu.glowacki.jaxws.api.sample.ICalculator.URI + IService.WSDL_SUFFIX);
        CalculatorImplService service = new CalculatorImplService(wsdl);
        return service.getICalculatorPort();
    }

    private static int constituent() {
        return RANDOM.nextInt();
    }

    private void layoutImpl() {
        Container content = getContentPane();
        SpringLayout layout = new SpringLayout();
        content.setLayout(layout);
        content.add(_scroll);
        content.add(_btnAdd);

        final int DEFAULT_PADDING = 5;
        layout.putConstraint(SpringLayout.WEST, _scroll, DEFAULT_PADDING, SpringLayout.WEST, content);
        layout.putConstraint(SpringLayout.NORTH, _scroll, DEFAULT_PADDING, SpringLayout.NORTH, content);
        layout.putConstraint(SpringLayout.EAST, _scroll, -DEFAULT_PADDING, SpringLayout.EAST, content);
        layout.putConstraint(SpringLayout.WEST, _btnAdd, DEFAULT_PADDING, SpringLayout.WEST, content);
        layout.putConstraint(SpringLayout.NORTH, _btnAdd, DEFAULT_PADDING, SpringLayout.SOUTH, _scroll);
        layout.putConstraint(SpringLayout.SOUTH, _btnAdd, -DEFAULT_PADDING, SpringLayout.SOUTH, content);
        layout.putConstraint(SpringLayout.EAST, _btnAdd, -DEFAULT_PADDING, SpringLayout.EAST, content);

        this.pack();
        final int DEFAULT_WIDTH = 640;
        final int DEFAULT_HEIGHT = 480;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void actionPerformed(ActionEvent event) {
        final int constituent1 = constituent();
        final int constituent2 = constituent();
        final int sum = _proxy.add(constituent1, constituent2);
        final String output = String.format("%d + %d = %d", constituent1, constituent2, sum);
        final String content = String.format("%s\n%s", _txtOutput.getText(), output);
        _txtOutput.setText(content);
    }
}
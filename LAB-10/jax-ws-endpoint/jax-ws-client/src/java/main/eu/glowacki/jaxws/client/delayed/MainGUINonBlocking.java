package eu.glowacki.jaxws.client.delayed;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.delayed.proxy.AddResponse;
import eu.glowacki.jaxws.client.delayed.proxy.CalculatorDelayedImplService;
import eu.glowacki.jaxws.client.delayed.proxy.ICalculatorDelayed;

import javax.swing.*;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public final class MainGUINonBlocking extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 465320630720463494L;

    private static final Random RANDOM = new Random();

    public static void main(String... args) {
        try {
            new MainGUINonBlocking();
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    private static ICalculatorDelayed proxyImpl() throws MalformedURLException {
        URL wsdl = new URL(eu.glowacki.jaxws.api.delayed.ICalculatorDelayed.URI + IService.WSDL_SUFFIX);
        CalculatorDelayedImplService service = new CalculatorDelayedImplService(wsdl);
        return service.getICalculatorDelayedPort();
    }

    private static int constituent() {
        return RANDOM.nextInt();
    }

    private final ICalculatorDelayed _proxy;
    private final Handler _handler;

    private final JButton _btnAdd;
    private final JTextArea _txtOutput;
    private final JScrollPane _scroll;

    private MainGUINonBlocking() throws MalformedURLException {
        _proxy = proxyImpl();
        _handler = new Handler();

        _btnAdd = new JButton("Add delayed");
        _btnAdd.addActionListener(this);
        _txtOutput = new JTextArea(20, 0);
        _scroll = new JScrollPane(this._txtOutput);

        layoutImpl();
        setVisible(true);
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

        pack();

        final int DEFAULT_WIDTH = 640;
        final int DEFAULT_HEIGHT = 480;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void actionPerformed(ActionEvent event) {
        final int constituent1 = constituent();
        final int constituent2 = constituent();
        _proxy.addAsync(constituent1, constituent2, _handler);
    }

    private final class Handler implements AsyncHandler<AddResponse> {

        private Handler() {
        }

        @Override
        public void handleResponse(Response<AddResponse> response) {
            try {
                int sum = response //
                        .get() //
                        .getReturn();
                final String content = String.format("%s\nasynchrounous result: %d", _txtOutput.getText(), sum);
                _txtOutput //
                        .setText(content);
            } catch (ExecutionException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
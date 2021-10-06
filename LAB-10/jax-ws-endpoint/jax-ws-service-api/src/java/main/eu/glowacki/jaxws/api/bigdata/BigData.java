package eu.glowacki.jaxws.api.bigdata;

import java.security.SecureRandom;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
		namespace = "http://glowacki.eu/big-data" //
)
public final class BigData {

	private static SecureRandom _random;
	private static final int DEFAULT_RAW_DATA_SIZE = 0x10000; // 64kB

	static {
		try {
			_random = SecureRandom.getInstanceStrong();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

	public static BigData generate() {
		byte[] data = generateRawData(DEFAULT_RAW_DATA_SIZE);
		return new BigData(data);
	}

	private static byte[] generateRawData(int size) {
		byte[] data = new byte[size];
		_random.nextBytes(data);
		return data;
	}

	public int _size;
	public byte[] _rawData;

	public BigData() {
	}

	public BigData(byte[] rawData) {
		_rawData = rawData;
		_size = (_rawData != null) ? _rawData.length : 0;
	}
}
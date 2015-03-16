public class CompareVersionNumbers {
	
	public int compareVersions(String v1, String v2) {
		String[] ver1 = v1.split(".");
		String[] ver2 = v2.split(".");

		for (int i = 0; i < ver1.length && i < ver2.length; i++) {
			int ver1Value = Integer.parseInt(ver1[i]);
			int ver2Value = Integer.parseInt(ver2[i]);
			if (ver1Value > ver2Value) {
				return 1;
			} else if (ver2Value > ver1Value) {
				return -1;
			}
		}

		if (ver1.length > ver2.length) {
			return 1;
		} else if (ver2.length > ver1.length) {
			return -1;
		}
		return 0;
	}
	
}

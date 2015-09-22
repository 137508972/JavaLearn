package IO;

import java.io.File;

public class BianliDir {
	public static void main(String[] args) {
		File f = new File("D:" + File.separator + "JavaFile");
		printBianli(f);
	}

	static void printBianli(File f) {
		if (f.listFiles().length > 0) {
			for (File fSub : f.listFiles()) {

				if (fSub.isDirectory()) {
					System.out.println("Ŀ¼��" + fSub.getPath());

					printBianli(fSub);
				}

				else {
					System.out.println("�ļ���" + fSub.getPath());
				}
			}
		}
	}
}

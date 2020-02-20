package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CheckFileExtensionMime {

    private static CheckFileExtensionMime instance;

    public static boolean checkFile(File myObj) throws IOException {
//        System.out.println("File name: " + myObj.getName());
//        System.out.println("Absolute path: " + myObj.getAbsolutePath());
//        System.out.println("Writeable: " + myObj.canWrite());
//        System.out.println("Readable: " + myObj.canRead());
//        System.out.println("File size in bytes: " + myObj.length());
        String extension = "";
        int i = myObj.getName().lastIndexOf('.');
        int p = Math.max(myObj.getName().lastIndexOf('/'), myObj.getName().lastIndexOf('\\'));
        if (i > p) {
            extension = myObj.getName().substring(i+1);
        }
        System.out.println("Extension: " + extension);


        byte[] fileContent = Files.readAllBytes(myObj.toPath());
        StringBuilder hex = new StringBuilder();
        int cont = 0;
        for(byte b : fileContent){
            if(cont < 12){
                hex.append(String.format("%02x", b));
                cont++;
            }else{
                break;
            }
        }

        System.out.println("HEX: " + hex.toString());

        return checkExtension(hex.toString(), extension);

    }

    private static boolean checkExtension(String hex, String extension) {
        boolean check = false;

        if (hex.substring(0, 10).equalsIgnoreCase("255044462d")) {
            System.out.println("Detected file format: pdf");
            if (extension.equalsIgnoreCase("pdf")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 3).equalsIgnoreCase("308")) {
            System.out.println("Detected file format: p7m or pdf.p7m");
            if (extension.equalsIgnoreCase("p7m") || extension.equalsIgnoreCase("pdf.p7m")) {
                check = true;
                return check;
            }
        }else if((hex.substring(0,8).equalsIgnoreCase("FFD8FFDB") ||
                hex.substring(0,24).equalsIgnoreCase("FFD8FFE000104A4649460001") ||
                hex.substring(0,8).equalsIgnoreCase("FFD8FFEE") ||
                hex.substring(0, 24).equalsIgnoreCase("FFD8FFE1????457869660000"))) {
            System.out.println("Detected file format: jpg or jpeg");
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 16).equalsIgnoreCase("D0CF11E0A1B11AE1")) {
            System.out.println("Detected file format: doc, xls, ppt or msg");
            if (extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("xls")
                    || extension.equalsIgnoreCase("ppt") || extension.equalsIgnoreCase("msg")) {
                check = true;
                return check;
            }
        }else if((hex.substring(0,8).equalsIgnoreCase("504B0304") ||
                hex.substring(0,8).equalsIgnoreCase("504B0506") ||
                hex.substring(0, 8).equalsIgnoreCase("504B0708"))) {
            System.out.println(
                    "Detected file format: zip, apk, docx, epub, ipa, jar, kmz, maff, odp, ods, odt, usdz, vsdx, xlsx, xpi");
            if (extension.equalsIgnoreCase("zip") || extension.equalsIgnoreCase("apk")
                    || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("epub")
                    || extension.equalsIgnoreCase("ipa") || extension.equalsIgnoreCase("jar")
                    || extension.equalsIgnoreCase("kmz") || extension.equalsIgnoreCase("maff")
                    || extension.equalsIgnoreCase("odp") || extension.equalsIgnoreCase("ods")
                    || extension.equalsIgnoreCase("odt") || extension.equalsIgnoreCase("usdz")
                    || extension.equalsIgnoreCase("vsdx") || extension.equalsIgnoreCase("xlsx")
                    || extension.equalsIgnoreCase("xpi")) {
                check = true;
                return check;
            }
        }else if((hex.substring(0,14).equalsIgnoreCase("526172211A0700") ||
                hex.substring(0, 16).equalsIgnoreCase("526172211A070100"))) {
            System.out.println("Detected file format: rar");
            if (extension.equalsIgnoreCase("rar")) {
                check = true;
                return check;
            }
        } else if ((hex.substring(0, 16).equalsIgnoreCase("89504E470D0A1A0A"))) {
            System.out.println("Detected file format: png");
            if (extension.equalsIgnoreCase("png")) {
                check = true;
                return check;
            }
        } else if ((hex.substring(0, 8).equalsIgnoreCase("CAFEBABE"))) {
            System.out.println("Detected file format: class");
            if (extension.equalsIgnoreCase("class")) {
                check = true;
                return check;
            }
        } else if ((hex.substring(0, 16).equalsIgnoreCase("3026B2758E66CF11"))) {
            System.out.println("Detected file format: asf, wma, wmv");
            if ((extension.equalsIgnoreCase("asf") || extension.equalsIgnoreCase("wma")
                    || extension.equalsIgnoreCase("wmv"))) {
                check = true;
                return check;
            }
        } else if ((hex.substring(0, 8).equalsIgnoreCase("38425053"))) {
            System.out.println("Detected file format: psd");
            if (extension.equalsIgnoreCase("psd")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 24).equalsIgnoreCase("52494646????????57415645")) {
            System.out.println("Detected file format: wav");
            if (extension.equalsIgnoreCase("wav")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 24).equalsIgnoreCase("52494646????????41564920")) {
            System.out.println("Detected file format: avi");
            if (extension.equalsIgnoreCase("avi")) {
                check = true;
                return check;
            }
        }else if((hex.substring(0,6).equalsIgnoreCase("494433") ||
                hex.substring(0, 4).equalsIgnoreCase("FFFB"))) {
            System.out.println("Detected file format: mp3");
            if (extension.equalsIgnoreCase("mp3")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 4).equalsIgnoreCase("424D")) {
            System.out.println("Detected file format: bmp or dib");
            if (extension.equalsIgnoreCase("bmp") || extension.equalsIgnoreCase("dib")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 10).equalsIgnoreCase("4344303031")) {
            System.out.println("Detected file format: iso");
            if (extension.equalsIgnoreCase("iso")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 16).equalsIgnoreCase("7573746172003030")
                || hex.substring(0, 16).equalsIgnoreCase("7573746172202000")) {
            System.out.println("Detected file format: tar");
            if (extension.equalsIgnoreCase("tar")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 12).equalsIgnoreCase("377ABCAF271C")) {
            System.out.println("Detected file format: 7z");
            if (extension.equalsIgnoreCase("7z")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 4).equalsIgnoreCase("1F8B")) {
            System.out.println("Detected file format: gz or tar.gz");
            if (extension.equalsIgnoreCase("gz") || extension.equalsIgnoreCase("tar.gz")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 8).equalsIgnoreCase("1A45DFA3")) {
            System.out.println("Detected file format: mkv, mka, mks, mk3d or webm");
            if (extension.equalsIgnoreCase("mkv") || extension.equalsIgnoreCase("mka")
                    || extension.equalsIgnoreCase("mks") || extension.equalsIgnoreCase("mk3d")
                    || extension.equalsIgnoreCase("webm")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 12).equalsIgnoreCase("3c3f786d6c20")) {
            System.out.println("Detected file format: xml");
            if (extension.equalsIgnoreCase("xml")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 12).equalsIgnoreCase("7B5C72746631")) {
            System.out.println("Detected file format: rtf");
            if (extension.equalsIgnoreCase("rtf")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 8).equalsIgnoreCase("000001BA")
                || hex.substring(0, 8).equalsIgnoreCase("000001B3")) {
            System.out.println("Detected file format: mpg or mpeg");
            if (extension.equalsIgnoreCase("mpg") || extension.equalsIgnoreCase("mpeg")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 12).equalsIgnoreCase("474946383761")
                || hex.substring(0, 12).equalsIgnoreCase("474946383961")) {
            System.out.println("Detected file format: gif");
            if (extension.equalsIgnoreCase("gif")) {
                check = true;
                return check;
            }
        } else if (hex.substring(0, 4).equalsIgnoreCase("4D5A")) {
            System.out.println("Detected file format: exe or dll");
            if (extension.equalsIgnoreCase("exe") || extension.equalsIgnoreCase("dll")) {
                check = true;
                return check;
            }
        } else {
            System.out.println("File format not recognized!");
        }

        return check;
    }

    public static CheckFileExtensionMime getInstance() {
        if(instance == null) {
            instance = new CheckFileExtensionMime();
        }
        return instance;
    }
}

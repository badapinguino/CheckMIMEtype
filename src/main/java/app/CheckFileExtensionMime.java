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

        if(hex.substring(0,10).equalsIgnoreCase("255044462d") && extension.equalsIgnoreCase("pdf")){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("30832d25"))
                && (extension.equalsIgnoreCase("p7m") || extension.equalsIgnoreCase("pdf.p7m"))){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("FFD8FFDB") ||
                hex.substring(0,24).equalsIgnoreCase("FFD8FFE000104A4649460001") ||
                hex.substring(0,8).equalsIgnoreCase("FFD8FFEE") ||
                hex.substring(0,24).equalsIgnoreCase("FFD8FFE1????457869660000"))
                && (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg"))){
            check = true;
            return check;
        }else if(hex.substring(0,16).equalsIgnoreCase("D0CF11E0A1B11AE1")
                && (extension.equalsIgnoreCase("doc") ||
                extension.equalsIgnoreCase("xls") ||
                extension.equalsIgnoreCase("ppt") ||
                extension.equalsIgnoreCase("msg"))){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("504B0304") ||
                hex.substring(0,8).equalsIgnoreCase("504B0506") ||
                hex.substring(0,8).equalsIgnoreCase("504B0708"))
                && (extension.equalsIgnoreCase("zip") ||
                extension.equalsIgnoreCase("apk") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("epub") ||
                extension.equalsIgnoreCase("ipa") ||
                extension.equalsIgnoreCase("jar") ||
                extension.equalsIgnoreCase("kmz") ||
                extension.equalsIgnoreCase("maff") ||
                extension.equalsIgnoreCase("odp") ||
                extension.equalsIgnoreCase("ods") ||
                extension.equalsIgnoreCase("odt") ||
                extension.equalsIgnoreCase("usdz") ||
                extension.equalsIgnoreCase("vsdx") ||
                extension.equalsIgnoreCase("xlsx") ||
                extension.equalsIgnoreCase("xpi"))){
            check = true;
            return check;
        }else if((hex.substring(0,14).equalsIgnoreCase("526172211A0700") ||
                hex.substring(0,16).equalsIgnoreCase("526172211A070100"))
                && extension.equalsIgnoreCase("rar")){
            check = true;
            return check;
        }else if((hex.substring(0,16).equalsIgnoreCase("89504E470D0A1A0A"))
                && extension.equalsIgnoreCase("png")){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("CAFEBABE"))
                && extension.equalsIgnoreCase("class")){
            check = true;
            return check;
        }else if((hex.substring(0,16).equalsIgnoreCase("3026B2758E66CF11"))
                && (extension.equalsIgnoreCase("asf") ||
                extension.equalsIgnoreCase("wma") ||
                extension.equalsIgnoreCase("wmv"))){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("38425053"))
                && (extension.equalsIgnoreCase("psd"))){
            check = true;
            return check;
        }else if((hex.substring(0,24).equalsIgnoreCase("52494646????????57415645"))
                && (extension.equalsIgnoreCase("wav"))){
            check = true;
            return check;
        }else if((hex.substring(0,24).equalsIgnoreCase("52494646????????41564920"))
                && (extension.equalsIgnoreCase("avi"))){
            check = true;
            return check;
        }else if((hex.substring(0,6).equalsIgnoreCase("494433") ||
                hex.substring(0,4).equalsIgnoreCase("FFFB"))
                && (extension.equalsIgnoreCase("mp3"))){
            check = true;
            return check;
        }else if((hex.substring(0,4).equalsIgnoreCase("424D"))
                && (extension.equalsIgnoreCase("bmp") ||
                extension.equalsIgnoreCase("dib"))){
            check = true;
            return check;
        }else if((hex.substring(0,10).equalsIgnoreCase("4344303031"))
                && (extension.equalsIgnoreCase("iso"))){
            check = true;
            return check;
        }else if((hex.substring(0,16).equalsIgnoreCase("7573746172003030") ||
                hex.substring(0,16).equalsIgnoreCase("7573746172202000"))
                && (extension.equalsIgnoreCase("tar"))){
            check = true;
            return check;
        }else if((hex.substring(0,12).equalsIgnoreCase("377ABCAF271C"))
                && (extension.equalsIgnoreCase("7z"))){
            check = true;
            return check;
        }else if((hex.substring(0,4).equalsIgnoreCase("1F8B"))
                && (extension.equalsIgnoreCase("gz") ||
                extension.equalsIgnoreCase("tar.gz"))){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("1A45DFA3"))
                && (extension.equalsIgnoreCase("mkv") ||
                extension.equalsIgnoreCase("mka") ||
                extension.equalsIgnoreCase("mks") ||
                extension.equalsIgnoreCase("mk3d") ||
                extension.equalsIgnoreCase("webm"))){
            check = true;
            return check;
        }else if((hex.substring(0,12).equalsIgnoreCase("3c3f786d6c20"))
                && (extension.equalsIgnoreCase("xml"))){
            check = true;
            return check;
        }else if((hex.substring(0,12).equalsIgnoreCase("7B5C72746631"))
                && (extension.equalsIgnoreCase("rtf"))){
            check = true;
            return check;
        }else if((hex.substring(0,8).equalsIgnoreCase("000001BA") ||
                hex.substring(0,8).equalsIgnoreCase("000001B3"))
                && (extension.equalsIgnoreCase("mpg") ||
                extension.equalsIgnoreCase("mpeg"))){
            check = true;
            return check;
        }else if((hex.substring(0,12).equalsIgnoreCase("474946383761") ||
                hex.substring(0,12).equalsIgnoreCase("474946383961"))
                && (extension.equalsIgnoreCase("gif"))){
            check = true;
            return check;
        }else if((hex.substring(0,4).equalsIgnoreCase("4D5A"))
                && (extension.equalsIgnoreCase("exe") ||
                extension.equalsIgnoreCase("dll"))){
            check = true;
            return check;
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

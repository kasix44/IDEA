/*package symmetricCryptography;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import java.util.Base64;
import java.util.Scanner;

public class IDEA {
    public static void main(String[] args) throws Exception {
        // Krok 1: Dodajemy Bouncy Castle jako Security Provider
        Security.addProvider(new BouncyCastleProvider());

        // Krok 2: Generujemy losowy klucz IDEA
        KeyGenerator keyGenerator = KeyGenerator.getInstance("IDEA", "BC");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();


        // Krok 3: Tworzymy instancje szyfru dla algorytmu IDEA
        Cipher cipher = Cipher.getInstance("IDEA/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);


        // Dodajemy dane do zaszyfrowania
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message to encrypt using IDEA: ");
        String userMessage = sc.nextLine();

        // Krok 4: Szyfrujemy dane
        byte [] encryptedData = cipher.doFinal(userMessage.getBytes());

        // Krok 5: Kodujemy zaszyfrowane dane w Base64 aby ułatwić drukowanie
        String cipherTextBase64 = Base64.getEncoder().encodeToString(encryptedData);
        System.out.println("Encrypted message is " + cipherTextBase64);

        // Krok 6: Inicjujemy szyfr do deszyfrowania
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte [] decodedOriginalData = cipher.doFinal(encryptedData);


        // Krok 7: Odszyfrowujemy dane

        // Krok 8: Przekształcamy odszyfrowane dane do ciągu znaków używając UTF-8
        System.out.println("The original message is " + new String(decodedOriginalData));

    }
}
*/








/* SYSTEM BASE64*/
package symmetricCryptography;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import java.util.Scanner;

public class IDEA {
    public static void main(String[] args) throws Exception {
        // Krok 1: Dodajemy Bouncy Castle jako Security Provider
        Security.addProvider(new BouncyCastleProvider());

        // Krok 2: Generujemy losowy klucz IDEA
        KeyGenerator keyGenerator = KeyGenerator.getInstance("IDEA", "BC");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Krok 3: Tworzymy instancję szyfru dla algorytmu IDEA
        Cipher cipher = Cipher.getInstance("IDEA/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Dodajemy dane do zaszyfrowania
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message to encrypt using IDEA: ");
        String userMessage = sc.nextLine();

        // Krok 4: Szyfrujemy dane
        byte[] encryptedData = cipher.doFinal(userMessage.getBytes());

        // Krok 5: Konwersja zaszyfrowanych danych na format heksadecymalny
        String cipherTextHex = bytesToHex(encryptedData);
        System.out.println("Encrypted message in hex is: " + cipherTextHex);

        // Krok 6: Inicjujemy szyfr do deszyfrowania
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedOriginalData = cipher.doFinal(encryptedData);

        // Krok 7: Odszyfrowujemy dane
        System.out.println("The original message is: " + new String(decodedOriginalData));
    }

    // Metoda konwersji bajtów na format heksadecymalny
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0'); // Dodaj zero na początku jeśli długość jest 1
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

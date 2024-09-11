 class Encryptor {
    public static void main(String[] args) {
        String input1="Wipro Tech"; 
        int val=20; 
     
        String encryptedText=encrypt(input1,val);
        System.out.println("Encrypted text: "+encryptedText);
    }

    public static String encrypt(String text,int val) {
        StringBuilder encrypted = new StringBuilder();
        
        for (char c:text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = encryptChar(c,val);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c); 
            }
        }
        
        return encrypted.toString();
    }

    public static char encryptChar(char c, int val) {
        int base = Character.isLowerCase(c) ? 'a' : 'A';
        int charValue=c-base; 
        int newCharValue=(charValue + val) % 26; 
        char encryptedChar = (char) (base+newCharValue); 
       
        return Character.isLowerCase(c) ? Character.toUpperCase(encryptedChar) : Character.toLowerCase(encryptedChar);
    }
}

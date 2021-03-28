import java.security.SecureRandom;

public class PasswortGen {
        private static final SecureRandom secureRandom = new SecureRandom();

        private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
        private static final String alphaCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String numeric = "0123456789";
        private static final String specials = "!§$%&/()=?.:,;+*#<>";

        public enum CharacterSet {
            Alpha,
            AlphaCaps,
            AlphaBoth,
            Numeric,
            AlphaNumeric,
            Special,
            All
        }

        private static String getCharacters (CharacterSet characterSet){

            switch (characterSet) {
                case Alpha:
                    return alpha;
                case AlphaCaps:
                    return alphaCaps;
                case AlphaBoth:
                    return alpha + alphaCaps;
                case Numeric:
                    return numeric;
                case AlphaNumeric:
                    return alpha + alphaCaps + numeric;
                case Special:
                    return specials;
                case All:
                    return alpha + alphaCaps + numeric + specials;
            }

            return alpha;
        }

        public static String generatePassword ( int length, CharacterSet characterSet){

            String characters = getCharacters(characterSet);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < length; i++) {
                stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
            }

            return stringBuilder.toString();
        }
    }

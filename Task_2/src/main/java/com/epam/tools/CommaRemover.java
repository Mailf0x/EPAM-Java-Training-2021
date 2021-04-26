package com.epam.tools;

/** CommaRemover class is responsible for removing commas from string. */
public class CommaRemover {

    /**
     * Removes commas from string.
     * @param      param
     *             String with commas.
     * @return     Source string without commas.
     * @throws     NullPointerException
     *             If source is null.
     */
    public static String remove(String source) {
        final String COMMA = ",";
        String result = null;
		StringBuilder sb = null;

        try {
            sb = new StringBuilder(source);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }

        while ( sb.indexOf(COMMA) != -1 ) {
            sb.deleteCharAt( sb.indexOf(COMMA) );
        }
        result = sb.toString();
        return result;
    }
}

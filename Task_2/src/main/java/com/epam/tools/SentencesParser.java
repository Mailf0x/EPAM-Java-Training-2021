package com.epam.tools;

import java.util.ArrayList;
import com.epam.storage.Sentence;

/** SentenceParser class is responsible for parsing sentences from text. */
public class SentencesParser {

    /**
     * Parses sentences from text.
     * @param     source
     *            String with text.
     * @return    Set of sentences.
     * @throws    NullPointerException
     *            If source is null.
     */
    public static ArrayList<Sentence> parse(String source) {
        final String COMMA = ",";
        final String DOT = "\\.";
        final String ELLIPSIS = "\\.\\.\\.";
        final String SPACE = " ";
        ArrayList<Sentence> result = new ArrayList<>();

        try {

            String[] pb = source.split(ELLIPSIS);

            for (String i : pb) {
                String b = i.trim();
                String[] sb = b.split(DOT);

                for (String j : sb) {
                    ArrayList<String> wb = new ArrayList<>();
                    String bf = j.trim();
                    String[] awb = bf.split(SPACE);

                    for (int k = 0; k != awb.length; k++) {

                        if ( awb[k].contains(COMMA) ) {
                            awb[k] = CommaRemover.remove(awb[k]);
                        }

                        if ( !awb[k].isEmpty() ) {
                            wb.add(awb[k]);
                        }
                    }
                    result.add( new Sentence(wb) );
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}

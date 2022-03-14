package com.parshin.composite.util;

import com.parshin.composite.entity.TextComponentType;
import com.parshin.composite.entity.TextComposite;
import com.parshin.composite.parser.ParagraphParserChain;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BitOperationCalculatorTest {
    public final String testText = "\tThe point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78\n" +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content\n" +
            "here), content here', making it look like readable English.\n" +
            "\tIt is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page\n" +
            "when looking at its layout.";
    ParagraphParserChain parser;
    TextComposite textComposite;

    @BeforeMethod
    public void setUp() {
        parser = new ParagraphParserChain();
        textComposite = new TextComposite(TextComponentType.TEXT);
    }

    @Test
    public void testCalculateBitExpression() {
        parser.parse(textComposite, testText);
        String actual = textComposite.toString();
        String expected = "\tThe point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, " +
                "as opposed to using (Content here), content here', making it look like readable English. \n" +
                "\tIt is a 1202 established fact that a reader will be of a page when looking at its layout. \n";
        assertEquals(actual, expected);
    }
}
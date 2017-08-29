/*
 * The MIT License
 *
 * Copyright 2017 Micha� Szyma�ski, kontakt: michal.szymanski.aajar@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package code.configuration.misc;

import code.misc.StringToMapConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Micha� Szyma�ski, kontakt: michal.szymanski.aajar@gmail.com
 */
public class StringToMapConverterTest {

    public StringToMapConverterTest() {
    }

    ObjectMapper mapper;

    StringToMapConverter converter;

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mapper = new ObjectMapper();
        this.converter = new StringToMapConverter();
    }

    /**
     * Test of convert method, of class StringToMapConverter.
     */
    @Test
    public void testConvert() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");

        String json = mapper.writeValueAsString(map);
        Map result = converter.convert(json);

        assertEquals(map.get("key1"), result.get("key1"));
        assertEquals(map.get("key2"), result.get("key2"));
    }

}
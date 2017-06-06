package com.liu.dai.util;

import com.google.common.base.Preconditions;
import com.liu.dai.exception.BussinessException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by liuyan9 on 2017/6/5.
 */
public class XmlHelper {

    private final XPath path;
    private final Document doc;

    private XmlHelper(InputSource inputSource) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = getDocumentBuilderFactory();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(inputSource);
        path = getXPathFactory().newXPath();
    }

    public static XmlHelper newInstance(String xml) {
        Preconditions.checkNotNull(xml);
        StringReader sr = null;
        try {
            sr = new StringReader(xml.trim());
            InputSource inputSource = new InputSource(sr);
            XmlHelper xmlHelper = create(inputSource);
            return xmlHelper;
        } finally {
            if (sr != null) {
                sr.close();
            }
        }
    }

    private static XmlHelper create(InputSource inputSource) {
        try {
            return new XmlHelper(inputSource);
        } catch (ParserConfigurationException e) {
            throw new BussinessException.DefaultException(e);
        } catch (IOException e) {
            throw new BussinessException.DefaultException(e);
        } catch (SAXException e) {
            throw new BussinessException.DefaultException(e);
        }
    }

    public String getString(String expression) {
        return (String) evalXPath(expression, null, XPathConstants.STRING);
    }

    public Boolean getBoolean(String expression) {
        return (Boolean) evalXPath(expression, null, XPathConstants.BOOLEAN);
    }

    public Number getNumber(String expression) {
        return (Number) evalXPath(expression, null, XPathConstants.NUMBER);
    }

    private Object evalXPath(String expression, Object item, QName returnType) {
        item = null == item ? doc : item;
        try {
            return path.evaluate(expression, item, returnType);
        } catch (XPathExpressionException e) {
            throw new BussinessException.DefaultException(e);
        }
    }

    private DocumentBuilderFactory getDocumentBuilderFactory() {
        return XmlHelperHolder.documentBuilderFactory;
    }

    private XPathFactory getXPathFactory() {
        return XmlHelperHolder.xPathFactory;
    }

    private static class XmlHelperHolder {
        private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        private static XPathFactory xPathFactory = XPathFactory.newInstance();
    }

}

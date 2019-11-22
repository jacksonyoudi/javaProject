package com.jackson.web;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class XmlTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // sax解析
        // 2. 从解析工厂中获取解析器
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 3.编写处理器
        SAXParser parser = factory.newSAXParser();
        // 4. 加载文档docunment注册处理器
        PHandler pHandler = new PHandler();

        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jackson/web/person.xml"), pHandler);
    }

}


class PHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("start");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "开始");
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "结束");
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        System.out.println("contents:" + contents);
    }
}
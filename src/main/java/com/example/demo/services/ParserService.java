package com.example.demo.services;

import javax.xml.parsers.*;

import com.example.demo.dto.Dictionary;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ParserService {

    public List<Dictionary> extractDict(String path) {
        NodeList nodeList = parseDocument(path);
        List<Dictionary> dictionaryObjects = new ArrayList<>(100000);
        for (int i = 0; i < Objects.requireNonNull(nodeList).getLength(); i++) {
            Node node = nodeList.item(i);
            Dictionary dobj = new Dictionary();
            if (node.getChildNodes().getLength() == 3) {
                dobj.setFrom(String.valueOf(node.getChildNodes().item(0).getTextContent()));
                dobj.setTo(String.valueOf(node.getChildNodes().item(2).getTextContent()));
                dobj.setComment(String.valueOf(node.getChildNodes().item(1).getTextContent()));
            } else if (node.getChildNodes().getLength() < 2) {
                continue;
            } else {
                dobj.setFrom(String.valueOf(node.getChildNodes().item(0).getTextContent()));
                dobj.setTo(String.valueOf(node.getChildNodes().item(1).getTextContent()));
            }
            dictionaryObjects.add(dobj);
        }
        return dictionaryObjects;
    }

    private NodeList parseDocument(String filePath) {

        try {
            Path file = FileSystems.getDefault().getPath(filePath);
            StringBuilder stringBuilder = new StringBuilder(200000);
            try (Stream<String> lines = Files.lines(file, Charset.defaultCharset())) {
                lines.forEach(stringBuilder::append);
            }
            DocumentBuilderFactory dbf =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(stringBuilder.toString()));
            Document doc = db.parse(is);
            return doc.getElementsByTagName("ar");
        } catch (FileNotFoundException | ParserConfigurationException | SAXException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

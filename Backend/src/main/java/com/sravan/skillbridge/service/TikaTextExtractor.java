package com.sravan.skillbridge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TikaTextExtractor {

    public String extractText(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "";
        }

        byte[] bytes = file.getBytes();
        ByteArrayResource resource = new ByteArrayResource(bytes);

        try {
            TikaDocumentReader reader = new TikaDocumentReader(resource, ExtractedTextFormatter.defaults());
            return reader.get().stream()
                    .map(doc -> doc.getText() != null ? doc.getText() : "")
                    .collect(Collectors.joining("\n"))
                    .trim();
        } catch (Exception e) {
            log.warn("Tika extraction failed for file {}: {}", file.getOriginalFilename(), e.getMessage());
            throw new IOException("Failed to extract text from file", e);
        }
    }
}

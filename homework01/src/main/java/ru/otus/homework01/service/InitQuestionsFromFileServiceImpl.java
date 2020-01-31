package ru.otus.homework01.service;

import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.homework01.model.Answer;
import ru.otus.homework01.model.EnquiryQuestion;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitQuestionsFromFileServiceImpl implements InitQuestionsService {

    private List<EnquiryQuestion> enquiryQuestionList;

    public InitQuestionsFromFileServiceImpl(final String fileName) {
        this.enquiryQuestionList = new ArrayList<>();

        final Resource resource = new ClassPathResource(fileName);
        try (CSVReader reader = new CSVReader(new FileReader(resource.getFile()))) {
            readQuestionsFromCsvFile(enquiryQuestionList, reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readQuestionsFromCsvFile(final List<EnquiryQuestion> enquiryQuestionList,
                                          final CSVReader reader) throws IOException {
        String[] csvLine;
        while ((csvLine = reader.readNext()) != null) {
            if (csvLine.length > 0) {
                enquiryQuestionList.add(new EnquiryQuestion(csvLine[0], parseAnswerList(csvLine)));
            }
        }
    }

    private List<Answer> parseAnswerList(final String[] csvLine) {
        List<Answer> answerList = new ArrayList<>();
        for (int i = 1; i < csvLine.length - 1; i += 2) {
            answerList.add(new Answer(csvLine[i], Boolean.parseBoolean(csvLine[i + 1])));
        }
        return answerList;
    }

    @Override
    public List<EnquiryQuestion> getAllQuestions() {
        return enquiryQuestionList;
    }
}

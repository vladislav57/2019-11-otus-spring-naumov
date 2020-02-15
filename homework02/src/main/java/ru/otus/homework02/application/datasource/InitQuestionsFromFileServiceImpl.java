package ru.otus.homework02.application.datasource;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.homework02.domain.application.InitQuestionsService;
import ru.otus.homework02.domain.model.Answer;
import ru.otus.homework02.domain.model.EnquiryQuestion;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class InitQuestionsFromFileServiceImpl implements InitQuestionsService {

    private final List<EnquiryQuestion> enquiryQuestionList;

    InitQuestionsFromFileServiceImpl(@Value("${enquiry.questions.file}") final String fileName) {
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

package com.example.fmssbitirmeodevibackend.mapper.mymapper;

import com.example.fmssbitirmeodevibackend.annotations.MyLog;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Keşif amacıyla yazıldı
 */

@SupportedAnnotationTypes("com.example.fmssbitirmeodevibackend.annotations.MyLog")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            JavaFileObject builderFile = processingEnv.getFiler().createSourceFile("Merhaba");
            PrintWriter printWriter = new PrintWriter(builderFile.openWriter());
            printWriter.println("package com.example.fmssbitirmeodevibackend.mapper.mymapper;");
            printWriter.print("public class Merhaba{}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

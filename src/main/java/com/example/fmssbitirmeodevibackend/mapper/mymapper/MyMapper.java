package com.example.fmssbitirmeodevibackend.mapper.mymapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @apiNote
 * Bu sınıfı reflection tekrarı amacıyla yazdım. İlgili sınıfların getter ve setter methodlarını kullanarak mapleme
 * işlemi gerçekleştirmeye çalıştım.
 * <br></br>
 * <br></br>
 * Lombok @Getter @Setter @NoArgsConstructor kullanılmış sınıflar üzerinde mapleme işlemi gerçekleştirebilir.
 * <br></br>
 * <br></br>
 * @// FIXME: public getter/setter
 * <br></br>
 * getter ve setter methodlarının public olacağı garanti edilirse getterMethodName ve setterMethodName kuralları
 * bir şekilde oluşturulabilir ve bu sayede sınıftaki stream yapısı kaldırılarak karmaşıklık düşürülebilir. Ayrıca
 * record classlar için consturctor'a parametre geçilerek newleme yapılabilir.
 */

public class MyMapper{
    public <T,U> U convert(T input, Class<U> output){
        Field[] inputFields = input.getClass().getDeclaredFields(); //debug için
        Field[] outputFields = input.getClass().getDeclaredFields();
        final Method[] inputDeclaredMethods = input.getClass().getDeclaredMethods();
        final Method[] outputDeclaredMethods = output.getDeclaredMethods();

        try {
            U o = output.getDeclaredConstructor().newInstance();

            Arrays.stream(outputFields).forEach(field -> {
                String getterMethodName = "get" + capitalize(field.getName());
                String setterMethodName = "set" + capitalize(field.getName());

                Arrays.stream(inputDeclaredMethods).forEach(method -> {
                    String currentMethodName = method.toString();
                    if(currentMethodName.contains(getterMethodName)){
                        try {
                            Object getFieldValue = method.invoke(input);
                            Arrays.stream(outputDeclaredMethods).forEach(method1 -> {
                                String currentMethodName1 = method1.toString();
                                if (currentMethodName1.contains(setterMethodName)){
                                    try {
                                        method1.invoke(o,getFieldValue);
                                    } catch (IllegalAccessException | InvocationTargetException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            });
            return o;
        }catch (Exception e){
            try {
                return output.getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

//    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        CreateEmployeeRequest createEmployeeRequest = CreateEmployeeRequest.builder()
//                .name("Burhan")
//                .surname("Taşkesen")
//                .birthDate(ZonedDateTime.now().plusDays(10))
//                .department(Department.BACKEND)
//                .email("taskesenburhan@gmail.com")
//                .grade(Grade.J1)
//                .role(Role.DEVELOPER)
//                .salary(0)
//                .tcNo("123456789101")
//                .title("customTitle")
//                .startDate(ZonedDateTime.now())
//                .build();
//
//        var converted = new MyMapper().convert(createEmployeeRequest, Employee.class);
//
//        System.out.println(converted);
//    }
}

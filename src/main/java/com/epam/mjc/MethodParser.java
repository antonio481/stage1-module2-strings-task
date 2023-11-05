package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        if(signatureString.startsWith("public")||signatureString.startsWith("private")||signatureString.startsWith("protected")) {
            String[] firstHalfName = signatureString.split(" ");
            String modifier=firstHalfName[0];
            String returnType=firstHalfName[1];
            String methodName=firstHalfName[2];
            if(methodName.contains("(")){
                int index=methodName.indexOf("(");
                methodName=methodName.substring(0,index);
            }
            String []secondHalfMethodName=signatureString.split("\\(");
            String []arguments=secondHalfMethodName[1].split(",");
            List<MethodSignature.Argument> transfersArguments = new ArrayList<>();
            if(arguments.length>0&&arguments.length!=1){
                for (String s : arguments) {
                    String[] argument = (s.split(" "));
                    transfersArguments.add(new MethodSignature.Argument(argument[0], argument[1]));
                }
            }
            MethodSignature methodSignature=new MethodSignature(methodName,transfersArguments);
            methodSignature.setAccessModifier(modifier);
            methodSignature.setReturnType(returnType);
            methodSignature.setMethodName(methodName);
            return methodSignature;
            /*throw new UnsupportedOperationException("You should implement this method.");*/}
        String[] firstHalfName = signatureString.split(" ");
        String returnType=firstHalfName[0];
        String methodName=firstHalfName[1];
        if(methodName.contains("(")){
            int index=methodName.indexOf("(");
            methodName=methodName.substring(0,index);
        }
        String []secondHalfMethodName=signatureString.split("\\(");
        String []arguments=secondHalfMethodName[1].split(",");
        List<MethodSignature.Argument> transfersArguments = new ArrayList<>();
        for (String s : arguments) {
            String[] argument = (s.split(" "));
            transfersArguments.add(new MethodSignature.Argument(argument[0], argument[1]));
        }
        MethodSignature methodSignature=new MethodSignature(methodName,transfersArguments);
        methodSignature.setMethodName(methodName);
        methodSignature.setReturnType(returnType);
    return methodSignature;
    }
}

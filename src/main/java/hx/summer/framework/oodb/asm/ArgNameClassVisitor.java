/**
 *    Copyright 2018-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package hx.summer.framework.oodb.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author mingliang
 * @Date 2018-06-11 17:28
 */
public class ArgNameClassVisitor extends ClassVisitor {
    private List<String> argumentNames = new ArrayList<>();
    private Map<String,Class<?>> argTypeMap = new HashMap<>();

    public ArgNameClassVisitor() {
        super(Opcodes.ASM5);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        Type methodType = Type.getMethodType(desc);
        Type[] types = methodType.getArgumentTypes();
//        argTypeMap.put()
        int len = types.length;
        return new ArgNameMethodVisitor(Opcodes.ASM5,argumentNames,len);
    }

    public List<String> getArgumentNames() {
        return argumentNames;
    }

    public Map<String, Class<?>> getArgTypeMap() {
        return argTypeMap;
    }
}

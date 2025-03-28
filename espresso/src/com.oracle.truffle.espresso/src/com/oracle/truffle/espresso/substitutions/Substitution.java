/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.espresso.substitutions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Marks methods and classes (Truffle's {@link com.oracle.truffle.api.nodes.Node nodes} to be used
 * as substitutions for guest Java methods.
 *
 * Usages of this annotation must enclosed by a final class annotated with
 * {@link EspressoSubstitutions}.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Substitution {
    /**
     * Substituted method name.
     *
     * <p>
     * Setting this parameter overrides any automatic name assigned to the substitution.
     *
     * <h3>Example:</h3>
     * 
     * <pre>
     * &#064;Substitution(methodName = "&lt;init&gt;")
     * </pre>
     */
    String methodName() default "";

    /**
     * Set to <code>true</code> to substitute instance methods. <code>false</code> for static
     * methods.
     *
     * <p>
     * The receiver's type is never part of the substituted method signature. For instance method
     * substitutions, the receiver parameter (<i>this</i>) must be present.
     *
     * <h3>Example substitution for {@link Object#hashCode() Object#hashCode()I}</h3>
     *
     * <pre>
     * &#064;Substitution(hasReceiver = true)
     * public static int hashCode(@JavaType(Object.class) StaticObject receiver) {
     *     return 42;
     * }
     * </pre>
     */
    boolean hasReceiver() default false;

    /**
     * If method or class names change across versions, a {@link SubstitutionNamesProvider} can be
     * specified to substitute for multiple cases at once.
     * <p>
     * Overrides the value of {@link #methodName()}.
     */
    Class<? extends SubstitutionNamesProvider> nameProvider() default SubstitutionNamesProvider.NoProvider.class;

    /**
     * Some substitution should happen only for a given guest java version, or even iff an option is
     * specified. this method allows to conditionally substitute based on the language.
     */
    Class<? extends LanguageFilter> languageFilter() default LanguageFilter.AlwaysValid.class;

    /**
     * Collects marker interfaces.
     */
    byte[] flags() default {};

}

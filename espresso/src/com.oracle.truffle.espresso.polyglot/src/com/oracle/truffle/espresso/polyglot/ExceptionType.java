/*
 * Copyright (c) 2020, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.espresso.polyglot;

/**
 * Represents a type of a Truffle exception.
 *
 * @see Interop#isException(Object)
 * @see Interop#getExceptionType(Object)
 * @since 21.0
 */
public enum ExceptionType {
    /**
     * Indicates that the application was exited within the guest language program. To obtain the
     * exit status use {@link Interop#getExceptionExitStatus(Object) getExceptionExitStatus}.
     *
     * @see Interop#getExceptionExitStatus(Object)
     * @since 21.0
     */
    EXIT,

    /**
     * Indicates that the application thread was interrupted by an {@link InterruptedException}.
     *
     * @since 21.0
     */
    INTERRUPT,

    /**
     * Indicates a guest language error.
     *
     * @since 21.0
     */
    RUNTIME_ERROR,

    /**
     * Indicates a parser or syntax error. Syntax errors typically occur while parsing of guest
     * language source code. Use {@link Interop#isExceptionIncompleteSource(Object)
     * isExceptionIncompleteSource} to find out if the parse error happened due to incomplete
     * source.
     *
     * @see Interop#isExceptionIncompleteSource(Object)
     * @since 21.0
     */
    PARSE_ERROR
}

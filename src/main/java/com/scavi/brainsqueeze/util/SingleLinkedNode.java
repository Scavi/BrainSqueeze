/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.util;

/**
 * @author Michael Heymel
 * @since 15/09/16
 */
public class SingleLinkedNode<T> {

    private final T _value;
    private SingleLinkedNode<T> _next;


    public SingleLinkedNode(final T value) {
        this(value, null);
    }


    public SingleLinkedNode(final T value, final SingleLinkedNode<T> next) {
        _value = value;
        _next = next;
    }


    public T getValue() {
        return _value;
    }


    public void setNext(final SingleLinkedNode<T> next) {
        _next = next;
    }


    public SingleLinkedNode<T> getNext() {
        return _next;
    }
}

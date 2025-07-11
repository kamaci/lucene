/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.search.spell;

import java.util.Comparator;
import org.apache.lucene.util.PriorityQueue;

/**
 * Sorts SuggestWord instances
 *
 * @see org.apache.lucene.search.spell.SuggestWordScoreComparator
 * @see org.apache.lucene.search.spell.SuggestWordFrequencyComparator
 */
public final class SuggestWordQueue extends PriorityQueue<SuggestWord> {
  /**
   * Default comparator: score then frequency.
   *
   * @see SuggestWordScoreComparator
   */
  public static final Comparator<SuggestWord> DEFAULT_COMPARATOR = new SuggestWordScoreComparator();

  /**
   * Use the {@link #DEFAULT_COMPARATOR}
   *
   * @param size The size of the queue
   */
  public SuggestWordQueue(int size) {
    this(size, DEFAULT_COMPARATOR);
  }

  /**
   * Specify the size of the queue and the comparator to use for sorting.
   *
   * @param size The size
   * @param comparator The comparator.
   */
  public SuggestWordQueue(int size, Comparator<SuggestWord> comparator) {
    super(size, (a, b) -> comparator.compare(a, b) < 0);
  }
}

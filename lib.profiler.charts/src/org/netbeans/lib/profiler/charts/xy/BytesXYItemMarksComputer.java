/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.lib.profiler.charts.xy;

import java.util.Iterator;
import org.netbeans.lib.profiler.charts.ChartContext;
import org.netbeans.lib.profiler.charts.axis.AxisMark;
import org.netbeans.lib.profiler.charts.axis.AxisMarksComputer;
import org.netbeans.lib.profiler.charts.axis.BytesAxisUtils;
import org.netbeans.lib.profiler.charts.axis.BytesMark;
import org.netbeans.lib.profiler.charts.swing.Utils;

/**
 *
 * @author Jiri Sedlacek
 */
public class BytesXYItemMarksComputer extends XYItemMarksComputer {

    private double scale;
    private long step;
    private int radix;


    public BytesXYItemMarksComputer(XYItem item,
                                    XYItemPainter painter,
                                    ChartContext context,
                                    int orientation) {

        super(item, painter, context, orientation);

        scale = -1;
        step = -1;
        radix = -1;

    }

    protected boolean refreshConfiguration() {
        double oldScale = scale;

        if (context.getViewWidth() == 0) {
            scale = -1;
//        } else if (item.getValuesCount() == 0) {
//            // Initial scale
//            scale = -1;
        } else {
            scale = painter.getItemValueScale(item, context);
        }
        
        if (oldScale != scale) {
            if (scale == -1) {
                step = -1;
                radix = -1;
            } else {
                long[] units = BytesAxisUtils.getBytesUnits(scale, getMinMarksDistance());
                step = units[0];
                radix = step == -1 ? -1 : (int)units[1];
            }

            oldScale = scale;
            return true;
        } else {
            return false;
        }
    }


    public Iterator<AxisMark> marksIterator(int start, int end) {
            if (step == -1) return EMPTY_ITERATOR;

            final long dataStart = ((long)painter.getItemValue(start, item,
                                          context) / step) * step;
            final long dataEnd = ((long)painter.getItemValue(end, item,
                                          context) / step) * step;
            final long iterCount = Math.abs(dataEnd - dataStart) / step + 2;
            final long[] iterIndex = new long[] { 0 };


            return new AxisMarksComputer.AbstractIterator() {

                public boolean hasNext() {
                    return iterIndex[0] < iterCount;
                }

                public AxisMark next() {
                    long value = reverse ? dataStart - iterIndex[0] * step :
                                           dataStart + iterIndex[0] * step;

                    iterIndex[0]++;
                    int position = Utils.checkedInt(Math.floor(
                                         painter.getItemView(value, item, context)));
                    return new BytesMark(value, position, radix);
                }

            };

        }

}

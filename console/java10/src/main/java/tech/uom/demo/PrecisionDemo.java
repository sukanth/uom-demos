/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2019, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.uom.demo;

import static tech.units.indriya.unit.Units.SECOND;

import java.math.BigInteger;

import javax.measure.MetricPrefix;

import tech.units.indriya.quantity.NumberQuantity;
import tech.units.indriya.quantity.Quantities;

public class PrecisionDemo {
	public static void main(String[] args)  {
	    final var valConst = 1548351392775L;
        var value = Long.valueOf(valConst);
        var valueBig = BigInteger.valueOf(valConst);
        var milli = NumberQuantity.of(value, MetricPrefix.MILLI(SECOND));
        var milliBig = Quantities.getQuantity(valueBig, MetricPrefix.MILLI(SECOND));
        var nano = milli.to(MetricPrefix.NANO(SECOND)).getValue();
        var nanoBig = milliBig.to(MetricPrefix.NANO(SECOND)).getValue();
        var nanoLong = nano.longValue();
        //assertEquals(value * 1000000, nanoLong);
        System.out.println(String.format("%s = %s = %s (%s) = %s (%s) ?", value * 1000000, nanoLong, 
                nano, nano instanceof BigInteger, 
                nanoBig, nanoBig instanceof BigInteger));
	}
}
package com.java17.certification.overview.tests;

interface I3 {
boolean m(Integer i1, Integer i2);

static boolean m(long l1, long l2) {
return l1 == l2;
}
}
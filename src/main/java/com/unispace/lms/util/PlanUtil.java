package com.unispace.lms.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class PlanUtil {
  public static Pair<Date, Date> getDateRangeForQuarter(Integer year, Integer quarterNumber) {
    return switch (quarterNumber) {
      case 1 -> Pair.of(
          new GregorianCalendar(year, Calendar.AUGUST, 31).getTime(),
          new GregorianCalendar(year, Calendar.NOVEMBER, 1).getTime());
      case 2 -> Pair.of(
          new GregorianCalendar(year, Calendar.OCTOBER, 31).getTime(),
          new GregorianCalendar(year + 1, Calendar.JANUARY, 1).getTime());
      case 3 -> Pair.of(
          new GregorianCalendar(year, Calendar.DECEMBER, 31).getTime(),
          new GregorianCalendar(year + 1, Calendar.APRIL, 1).getTime());
      case 4 -> Pair.of(
          new GregorianCalendar(year + 1, Calendar.MARCH, 31).getTime(),
          new GregorianCalendar(year + 1, Calendar.JUNE, 1).getTime());
      default -> null;
    };
  }
}

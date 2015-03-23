package com.linkedin.thirdeye.impl.storage;

import com.linkedin.thirdeye.api.MetricTimeSeries;
import com.linkedin.thirdeye.api.TimeRange;

import java.util.Collection;

/**
 * Time series data, keyed by {@link com.linkedin.thirdeye.impl.storage.DimensionStore}
 */
public interface MetricStore
{
  /**
   * @param id
   *  The dimension id, obtained from {@link DimensionStore#findMatchingKeys(com.linkedin.thirdeye.api.DimensionKey)}
   * @param timeSeries
   *  Time series data that should be aggregate for dimension id
   */
  void update(int id, MetricTimeSeries timeSeries);

  /**
   * Make all aggregate values for all dimensions zero
   */
  void clear();

  /**
   * @param logicalOffsets
   *  A collection of dimension ids
   * @param timeRange
   *  The time range for which to get aggregate time series (if null, all time in the metric store)
   * @return
   *  The aggregate time series for all dimension ids (logicalOffsets)
   */
  MetricTimeSeries getTimeSeries(Collection<Integer> logicalOffsets, TimeRange timeRange);

  /**
   * @return
   *  The minimum time in the metric store (or -1 if no data)
   */
  Long getMinTime();

  /**
   * @return
   *  The maximum time in the metric store (or -1 if no data)
   */
  Long getMaxTime();
}

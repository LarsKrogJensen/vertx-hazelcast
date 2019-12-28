package io.vertx.spi.cluster.hazelcast.impl;

import io.vertx.core.Promise;

import java.util.function.BiConsumer;

class HandlerCallBackAdapter<V> implements BiConsumer<V, Throwable> {

  private final Promise<V> promise;

  public HandlerCallBackAdapter(Promise<V> promise) {
    this.promise = promise;
  }


  @Override
  public void accept(V v, Throwable t) {
    if (t != null) {
      promise.fail(t);
    } else {
      promise.complete(v);
    }

  }

}

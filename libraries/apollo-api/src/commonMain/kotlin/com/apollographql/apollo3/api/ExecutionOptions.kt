package com.apollographql.apollo3.api

import com.apollographql.apollo3.api.http.HttpHeader
import com.apollographql.apollo3.api.http.HttpMethod

interface ExecutionOptions {
  val executionContext: ExecutionContext

  /**
   *
   * The HTTP method to use for the request
   *
   * Used by [com.apollographql.apollo3.api.http.DefaultHttpRequestComposer]
   */
  val httpMethod: HttpMethod?

  /**
   *
   * HTTP headers to use for the request
   * Used by [com.apollographql.apollo3.api.http.DefaultHttpRequestComposer]
   */
  val httpHeaders: List<HttpHeader>?

  /**
   *
   * Whether to send the Auto Persisted Queries extensions
   * Used by [com.apollographql.apollo3.api.http.DefaultHttpRequestComposer]
   */
  val sendApqExtensions: Boolean?

  /**
   *
   * Whether to send the document
   * Used by [com.apollographql.apollo3.api.http.DefaultHttpRequestComposer]
   */
  val sendDocument: Boolean?

  /**
   *
   * Whether to enable Auto Persisted Queries and try to send a hashed query first
   * Used by [com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor]
   */
  val enableAutoPersistedQueries: Boolean?

  val canBeBatched: Boolean?

  companion object {
    /**
     * Used by [com.apollographql.apollo3.network.http.BatchingHttpInterceptor]
     */
    const val CAN_BE_BATCHED = "X-APOLLO-CAN-BE-BATCHED"
  }
}


interface MutableExecutionOptions<T> : ExecutionOptions {
  fun addExecutionContext(executionContext: ExecutionContext): T

  /**
   * Configures whether the request should use GET or POST
   * Usually, POST request can transfer bigger GraphQL documents but are more difficult to cache
   *
   * Default: [HttpMethod.Post]
   */
  fun httpMethod(httpMethod: HttpMethod?): T

  /**
   * Add HTTP headers to be sent with the request.
   */
  fun httpHeaders(httpHeaders: List<HttpHeader>?): T

  /**
   * Add an HTTP header to be sent with the request.
   */
  fun addHttpHeader(name: String, value: String): T

  fun sendApqExtensions(sendApqExtensions: Boolean?): T

  fun sendDocument(sendDocument: Boolean?): T

  fun enableAutoPersistedQueries(enableAutoPersistedQueries: Boolean?): T

  fun canBeBatched(canBeBatched: Boolean?): T
}

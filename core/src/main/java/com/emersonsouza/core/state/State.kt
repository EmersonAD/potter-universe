package com.emersonsouza.core.state

class State<out T>(
    val status: Status,
    val data: T?,
    val loading: Boolean,
    val error: Throwable?,
) {
    companion object {
        fun <T> success(data: T): State<T> =
            State(status = Status.Success, data = data, loading = false, error = null)

        fun <T> loading(loading: Boolean): State<T> =
            State(status = Status.Loading, data = null, loading = loading, error = null)

        fun <T> error(throwable: Throwable): State<T> =
            State(status = Status.Error, data = null, loading = false, error = throwable)
    }
}

enum class Status {
    Loading, Success, Error
}



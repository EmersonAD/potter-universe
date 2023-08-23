package com.emersonsouza.core.state

class State<out T>(
    status: Status,
    data: T?,
    loading: Boolean,
    error: Throwable?,
) {
    companion object {
        fun <T> success(data: T): State<T> =
            State(status = Status.Success, data = data, loading = false, error = null)

        fun <T> loading(data: T): State<T> =
            State(status = Status.Loading, data = null, loading = true, error = null)

        fun <T> error(throwable: Throwable): State<T> =
            State(status = Status.Error, data = null, loading = false, error = throwable)
    }
}

enum class Status {
    Loading, Success, Error
}



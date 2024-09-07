package org.example

enum class PaymentMethod {
    ONLINE,
    OFFLINE,
}

abstract class PaymentFactory {
    abstract fun createPayment(method: PaymentMethod): Payment;

    fun process(method: PaymentMethod) {
        val payment = createPayment(method)

        payment.paramValidation()
        payment.transfer()
        payment.sendMessage()
    }
}

/**
 * Nice는 Online/Offline 모두 메세지를 보냄
 */
class NicePaymentFactory : PaymentFactory() {
    override fun createPayment(method: PaymentMethod): Payment {
        return when (method) {
            PaymentMethod.ONLINE -> NiceOnlinePayment()
            PaymentMethod.OFFLINE -> NiceOfflinePayment()
        }
    }
}

class NiceOnlinePayment() : Payment() {
    override val description = "Nice online"
    override val method = PaymentMethod.ONLINE

    override fun transfer(): Boolean {
        println(this.description)
        return super.transfer()
    }

    override fun sendMessage(): Boolean {
        println("Nice - Success send message")
        return super.sendMessage()
    }
}

class NiceOfflinePayment() : Payment() {
    override val description = "Nice offline"
    override val method = PaymentMethod.OFFLINE

    override fun transfer(): Boolean {
        println(this.description)
        return super.transfer()
    }

    // Nice 인 경우에는 offline도 메세지를 보냄
    override fun sendMessage(): Boolean {
        println("Nice - Success send message")
        return super.sendMessage()
    }
}

/**
 * Toss는 온라인 결제일때만 메세지를 보냄
 */
class TossPaymentFactory : PaymentFactory() {
    override fun createPayment(method: PaymentMethod): Payment {
        return when (method) {
            PaymentMethod.ONLINE -> TossOnlinePayment()
            PaymentMethod.OFFLINE -> TossOfflinePayment()
        }
    }
}

class TossOnlinePayment() : Payment() {
    override val description = "Toss online"
    override val method = PaymentMethod.ONLINE

    override fun transfer(): Boolean {
        println(this.description)
        return super.transfer()
    }

    override fun sendMessage(): Boolean {
        println("Toss - Success send message")
        return super.sendMessage()
    }
}

class TossOfflinePayment() : Payment() {
    override val description = "Toss offline"
    override val method = PaymentMethod.OFFLINE

    override fun transfer(): Boolean {
        println(this.description)
        return super.transfer()
    }
}

abstract class Payment {
    abstract val description: String
    abstract val method: PaymentMethod

    open fun paramValidation(): Boolean {
        return true
    }

    open fun transfer(): Boolean {
        return true
    }

    open fun sendMessage(): Boolean {
        return true
    }
}
import org.example.NicePaymentFactory
import org.example.PaymentMethod
import org.example.TossPaymentFactory
import kotlin.test.Test

class NicePaymentFactoryTest {
    @Test
    fun test() {
        val nicePaymentFactory = NicePaymentFactory()
        nicePaymentFactory.process(PaymentMethod.OFFLINE)

        val tossPaymentFactory = TossPaymentFactory()
        tossPaymentFactory.process(PaymentMethod.OFFLINE)
    }
}
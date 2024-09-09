import org.example.Singleton
import kotlin.test.Test

class SingletonTest {
    @Test
    fun createSingleton() {
        val instance = Singleton.createInstance()
        instance.print()
    }
}
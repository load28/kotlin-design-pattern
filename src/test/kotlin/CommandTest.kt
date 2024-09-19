import org.example.CommandKimchi
import org.example.InvokeCommand
import org.example.Kimchi
import kotlin.test.Test
import kotlin.test.assertEquals

class CommandTest {
    @Test
    fun test() {
        // 커맨드를 관리하는 클래스
        val invoker = InvokeCommand()

        // 실제 요구사항이 존재하는 클래스
        val kimchi = Kimchi()
        // 요구사항을 공통 커맨드 인터페이스로 감싼 클래스
        val commandKimchi = CommandKimchi(kimchi)

        // 커맨드 객체 설정
        invoker.setCommend(commandKimchi)
        // 공통 인터페이스 함수 호출
        assertEquals(invoker.execute(), "Cook Kimchi")
        assertEquals(invoker.undo(), "None")
    }
}
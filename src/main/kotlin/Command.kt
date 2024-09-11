package org.example

abstract class Command {
    abstract fun execute(): String
}

class Kimchi() {
    fun cookKimchi(): String {
        return "Cook Kimchi"
    }
}

class CommandKimchi(private val kimchi: Kimchi) : Command() {
    override fun execute(): String {
        return kimchi.cookKimchi()
    }
}

class NoCommand : Command() {
    override fun execute(): String {
        return "No command"
    }
}

class InvokeCommand : Command() {
    private var commend: Command = NoCommand()

    fun setCommend(command: Command) {
        this.commend = command
    }

    override fun execute(): String {
        return this.commend.execute()
    }
}
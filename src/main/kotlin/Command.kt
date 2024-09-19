package org.example

abstract class Command {
    abstract fun execute(): String
    abstract fun undo(): String
}

class Kimchi() {
    fun cookKimchi(): String {
        return "Cook Kimchi"
    }
}

class CommandKimchi(private val kimchi: Kimchi) : Command() {
    private val prevCook: String = "None"

    override fun execute(): String {
        return kimchi.cookKimchi()
    }

    override fun undo(): String {
        return prevCook
    }
}

class NoCommand : Command() {
    override fun execute(): String {
        return "No command"
    }

    override fun undo(): String {
        return "No command"
    }
}

class InvokeCommand : Command() {
    private var commend: Command = NoCommand()

    fun setCommend(command: Command) {
        commend = command
    }

    override fun execute(): String {
        return commend.execute()
    }

    override fun undo(): String {
        return commend.undo()
    }
}
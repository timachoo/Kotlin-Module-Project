class CreareNote(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit, val archive: Archive) : Screen(nextScreen, exitScreen) {
    override fun printContent() {
        println("Создание Заметки")
        println("Введите название Заметки и нажмите ENTER")
        val noteName = readLine()?.trim()
        if (!InfoObject.checkName(noteName)) {
            println("Вы не ввели текст, попробуйте еще раз")
            printContent()
        }
        println("Введите текст заметки")
        val noteText = readLine()?.trim()
        if (InfoObject.checkName(noteText)) {
            println("Заметка $noteName успешно создана")
            archive.addNote(noteName!!, noteText!!)
            exit()
        } else {
            println("Вы не ввели текст, попробуйте еще")
            printContent()
        }
    }
}
class CreateArchiveScreen(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit) : Screen(nextScreen, exitScreen){
    override fun printContent() {
        println("Создание Архива")
        println("Введите название Архива и нажмите ENTER")
        val archName = readLine()?.trim()
        if (InfoObject.checkName(archName)){
            println("Архив $archName успешно создан")
            MenuNavigation.archives.add(Archive(archName!!))
            exit()
        } else {
            MenuNavigation.printNullText()
            printContent()
        }
    }
}
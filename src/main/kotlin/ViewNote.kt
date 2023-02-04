class ViewNote(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit, val note: Note) : Screen(nextScreen, exitScreen) {
    override fun printContent() {
        println(
            "Название заметки ${note.name} \n" +
                    "Текст заметки:\n" +
                    " ${note.text}"
        )
        MenuNavigation.navigationInput(
            "",
            mutableListOf(
                "Выйти",
            )
        ) { num ->
            when (num) {
                1 -> {
                    exit()
                }
            }
        }
    }
}
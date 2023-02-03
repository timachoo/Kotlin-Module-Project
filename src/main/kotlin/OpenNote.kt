class OpenNote(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit, val archive: Archive) : Screen(nextScreen, exitScreen){
    override fun printContent() {
        val title = if (archive.notes.size == 0) {
            "Заметок нет. Выберите действие:"
        } else {
            "Заметки. Выберите действие:"
        }
        val menu = mutableListOf(
            "Вернуться назад",
            "Создать заметку"
        )

        archive.notes.forEach {
            menu.add(it.name)
        }

        MenuNavigation.navigationInput(
            title,
            menu
        ) { num ->
            when (num) {
                1 -> {
                    exit()
                }
                2 -> {
                    nextScreen(Screens.CREATE_NOTE, archive)
                }
                else -> {
                    nextScreen(Screens.VIEW_NOTE, archive.notes[num-3])
                }
            }
        }

    }
}
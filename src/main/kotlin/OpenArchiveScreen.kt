class OpenArchiveScreen(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit) : Screen(nextScreen, exitScreen){
    override fun printContent() {
        val menu = mutableListOf(
            "Вернуться назад",
        )

        MenuNavigation.archives.forEach {
            menu.add(it.name)
        }

        MenuNavigation.navigationInput(
            "Архивы. Выберите действие:",
            menu
        ) { num ->
            when (num) {
                1 -> {
                    exit()
                }
                else -> {
                    nextScreen(Screens.OPEN_NOTE, MenuNavigation.archives[num - 2])
                }
            }
        }
    }
}
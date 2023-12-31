package day21

val testData = """...........
.....###.#.
.###.##..#.
..#.#...#..
....#.#....
.##..S####.
.##..#...#.
.......##..
.##.#.####.
.##..##.##.
...........""".split("\n")

val data = """...................................................................................................................................
....#..#...##..##........#...#.#.........#.....#.#....................#..###.#.#...#........##......#.#.......#............#.......
.#...#........................#.....#.#..............#....................#..#....................#...............##..#...##.#.....
....#......#..#.#.....#...............#........#........#.#...............#....#..#..#..##........................#.#...#..........
......................................#...#......#....#..................#.#......................#.....#....#....#.#....#....#....
..#.....#....#....#.#....#...#...#..............##..#...........#..................#.......#.......#...#....##...#.........#.......
....##..........#.........#.....#...#.#.#.......#.#...#............................#..#.............#.#............................
............#.#...............................#.....#............................#......#.......#........#.......#.....#...#.#.....
....#.......#........#......................#....#............#....#..........................#....#......##.....#...........##....
...#.#.#..##...........................#........................#...#.........##.....#...#.#..............#.#.....#.#...##..#......
..#.....#..#.................................#...#...........##.....#...........#........#.#..#..........##....#..#.#..............
....##..#.#...#..#...................#...#...#...............#.....#......................................#............#.......#...
............#..#...##....#.#..#............#...#.........##.......#........................#..............###.#...........#......#.
.......#..#......#...#.##..#...#....#.#.......................#.#.####....#...................#...#.........##.....##...........#..
.....#..#..............#....##..#....#.................#.#....#.....#...............#....#...................................#.....
..#.......#..#....##......#.....##........#...........#.#...........................#.#.....#...................###...........#..#.
.#....###.....#......#......#.........#......................#.#..........................##...#..#.............##...#...#.#.......
...#..##..#...................#.....#.#..#..#.........##....#..............#.#...........##.....#.......##..............#....#...#.
........#..............#...................................##........#....#...........................#...............#.......#.##.
.......#......#.............#..........#.................#.....##....##...##............##....................#.#.#........#....##.
...............#...........#..#.....#...............#......#.......#...#..#.##.............#.#..............##....#.........###....
....#.....#..##.................................#.....##........#...................................#....#...#.........#..#......#.
............#.........#....#...#.......................#.##.....#...................................#....#.....#..#.......#.....#..
...##..........#.#.....#..#........##....................#...............#..#..#........................#....#............#..#.....
...................#.....#......................#.#............#...........##......................#..#............#.....##........
...#.......##......#......#....#.............#...#............#...............#...................#.#.##........................#..
..#..#........##..#.#...#..#..#..##........#.#...............#........................#............#...#.......#.........#..#......
..................#..#..#.....#..................#.#.#..#...............#...#..###..#........................#.....#...#.......#...
............#.......##..........#..............#.....#.#...........#........##...##..##.#..........#.............#..#.#............
..........................#....#...........#.............#...........#....#......##...............#....#.....#....#.##.....#.#...#.
.#........#.............#........................#.#........##.#......#...........#.....##............###.....#.....#.....#........
......#..........#......#..#.......................#......................##.....#..#.......#........#....#.#..#..#.......#......#.
.....#........#..#.....#..#.............#.................#.........#..................#...#..........##....#.#.#..#.##........###.
...#......#.#.............#..............#.............#...#..#...##.#..#..........##......##..............##..#.#...#.........#...
......##..#......#.#....#.##.......#......#.#...................#.......#.....#..........................#........#...........#....
...#...............##.............#.............................#.......#.............#....#....................................#..
..#.#....#.#.....#.#...#..........#..#................#.....#........#.#...............#........#........................#....#....
....#....#.......#...............#..........##.#..................#...#...............#.#....#..............#......#.......#....##.
..#..................#......................#...#..##.....##.###......#.###...........#..#.............................##.......##.
..#..##...#..#....................#....#.#.#..#.#.#..#.#...##......#.#.#....#..........##.#..##.#..#..............##...............
.....#..............#.........................###.....##...............#.....#.....#..#......###.....#.............................
.......##....................................#.........#..#...#...##......#......#.#.#...#......##...#.......................#.#...
.#....#....#.......#............##.....................#.......#...#..#.......#...#..#...#.....................................#...
.#...#.......#..#...............##...........#....#.....##...#..........#.....#...#.........##....#..#.....................#..#.##.
......##..................#.##...#....#.................#...#.#........##.......#.....#........#.......#...............#..#....#...
.#........##.#..............#.....#...........#...#...#.#..#.#...........#....#.......#.....#...##.....................#.#...##..#.
......#..#..#.#........#...#......#........#.#.........##...........#............#..........#......................#..#..#.....#...
.#.......#..#.........#.#....#.#.##...........##.....#........#.#..........#......#..............#...#..#..............#..#........
.....#....#............#.#...........#..#.#..#............#...........#......#.#...........#...#................................#..
....##.................#.....##.....#.....................#..........#.#.#...#.....#...............#.....#.#.............#.........
......#...............#.#.#......#...##..........#...........##....#.............#.........#......#......#...................#.##..
.....#............#.......#.#.............#....#.......#..........#.##.#...#........##......#.....#.#...#..........................
....#....................#................#..#....#....##..#...#.....#........#..#.........#....#.......#......#.............#...#.
.#...#................#...#....................#.....#.....#........##........#....#.#...#...#..#..#.#...#..#......................
....#.........................#.....#..#..............##......#.#.....#............................#.#.....#.....#.................
......................#...##.........##........#..#.........#.....#...##...#..#.#...#..........................#.................#.
..#..#........#...#.......#....................#....#.......#.#.......#....#.......#.#.#.................#.....................##..
.#................#....#...............#.#..........#.......#...........#.##.#...#.....#..............#...#....#..#................
.#....................#................##.......#####......#..........#........#.............#.#.........#.#......#..#.............
..#.......#....#...#.#.................#.......#................#..#..#.....##..#.....................#..#....#....................
.........#.......##...#.#.........#.....#.........#.....#.#.#..##...#...#.......#....................#..#...#..#....#.#............
..............#.........#.....#.###....##...#.....#........##...#......#..........#...........#..##...#.....#.#........#...........
.........#.#..........#..........#.........#........##....#..##.........##......#..#..#........#.....#.....#.......................
.......#.#...........#........##.......#............#........#.#...............#..#.......#..#.........#.....#..#..#..#..#.........
.......#............#.#............#...........##..#.........#.....#......#..#...#.............................#......#..#.........
.................................................................S.................................................................
.......##....#...#......#...........#.........#.....#..#...........#.##....#.##..#........................................###......
.....................#...............#....#.........#..........#.....#..#.......#.......#...............#.#.....#..#...............
.........##..........#.....#.............#...#.........##..........##........##......#............#.#...##...#...#..#....#.#.......
............#..##........#..........#.##..............#................#..#..#..#...#.##........#......#.......#.......#.##........
.......................#.....#..#..#.....#....................#.............###.....#..#....#.......#...#.......#......#...........
.#........#.#.....#...#.#......#..#.#.#..#......##..........##..#.....#...............#............................................
.....................##..........#.....#.........#....#.........................#..........#...#.#.....#.....#...#.................
.##................#.......##...........#...#.#.........##..#.......#.......##................#........#...##.......#............#.
....................#.#.....#...#...#..#..##...##...#..................#......................#....##........................#.....
..#.............#...#.......#...#....#..#............#..#.#......................#.................#.#...#..#.....#.........#.#....
...................#.#......##.............#...............#..#.#......................#...............###..###..#..........#......
........#............#...#...#.#....#..#..........#..................#.........#.......#.........#..##......#..............#...#...
..##.............##.......##.#.#.#....#....#.#...#....................#..........#...#.......#..#..........#.#...............#.....
...#..............#.....#..............###......#........#..#.....#.......#...#..#.................#.#........#..........#.....#...
....#....#............#.#....#..........#............#.........##...............#.#................#...#...................#..#.#..
........#.#.........#....#.....#.....#.#..#.........................#..#.#.......##.#.........#......#..##....#........##.#........
......................#......#...........#......#......#.#................#...##.#....#......#.....#.................#...#.#...#...
.....#..#...................#...............###..........#.............#..#.#.....#....#....................................#.#.#..
.#.#.........#.........#......#.#...............#.....#..#......#.....#.#..#...##.........#...#....#............................#..
..#.#......#..............#.##.#..##....#.............#.....#....................###.....#...#..#.....................#.......#.#..
.#.#.........#.................#.#........#..##.........#..#.......#...##....#...#..........#.#...#..#.#...........#......#.###.##.
.........##..................#...#......##...##...#.............#..........#.....###......#...#...#.#.#.................##.#...#...
..........#...#..#...................#..#....##........#..........##............#......#........#.#.................#............#.
..#.....#......#..............#............................##..##.............##.......#.#..#.........#..........##...##.....#..#..
.............#..............................#.#........................#......##...............#..#................#.##...#........
...#..#.....#..##...#..................................#.....................#...#.....#.........#..........#........#...#.#.#.....
....#......#.##.....#..........#.....##.........#.#..#.........................................................#......#..##.#....#.
...................#............................#........#..#.................#.....#..#.......#..............##.#.....#...........
......#......#..#................#........#...#..#..............#......#....#.......#.....................#...........#....#...##..
..#..#.....#...#..#...............##.............#.#........#...........#.............##....#.#...........#.#.........###....##....
..#......#.#...#.........#...................................#........#...................................................#..#.....
.............#......#.......#........#.........#...........#....#..#...................##..............#.#...#.#...........#..#..#.
....#............#.....#.............#...#..........#.......#.....#......................#..#..........#.#....#...........#........
..........#.......##.....................##....##......#.............##.##...#..........#.#...................#..............##.#..
....#....#.........#.#..#..##.#....................#..............#.......#............................#.......#..........##....#..
..##.#.........#.......#...#..........................#.#.....#....#.....##......#....#...#...................................#....
..........#.....#..#....#...................#.....#.#...##..#.#................#.#...................##.........#........#....##...
.............#.........#.....#.............#.............##.............#.....#....#.................#...#.......#.#..#..#...#.#...
........##...#....#..........#......................#..#.#...........#........#..#.#..............#............#......#........#...
...#.#..#.#...............#..##..#..#.........#........#.#..........#.......#.........#........#.......#.......#..#....##.......#..
..#.......###.........#.....##.......#....................#..#......##.......#....##..........##........#.....................#....
.........#..#.....#.....#......#.....#........#...............#...#...#......#.................................#.#.#............##.
.....#.........#..#.........#..##......#...................##.....##.....#.....#............#.......#.....#..#..#..#..........#.#..
..........#.#.........#.......#..#...##......................................#..............#....##.#..#....#....#.##..............
...........###.#..........##...........................................#.........#.......#.....................#......##...........
...#........#.....#...................#.......................##.......#......#...........#..###.....#..#.......#........#.........
..##.....#..#..#.....#.................#.#.............#...##.........#................#.......................##.......#.....###..
..............##.#...#............#......#...........#..#.........#..#......#...........##....#....#.............##.#..............
.#..##.#.............#.....#.............................#.....#.........#.................##.#...#.....#.....#..#..#............#.
.#.#...#.##..........#..........#.......#.....................#..........##..............#.............#........#.#......#....#....
....#...................#.......#.....#................#.....#.....#.....#.............#.#.#..#.................#........#..#......
.............#...#.......#.#..#...##....#..#..#.........##.............#.............#.#.#.........#..................#............
............#..#...#..##....##..#.....#..........#.......##.#.......................................#.#..........................#.
..#................#...##.....#..........#...#...............#........................#....##.....#..............#...##.##.#..#.#..
....#.#...#.#.#.....#..#.##.#.##....#.#.##..#..................................##.......................##........#.#......##...#..
...#.....#.#..#..#.#.......#.......#..##.#.....#............#.#......##..............#.#...#.....#...#.#....#.........#.....#....#.
....###.#..............#.#.....##..........#......................#.#...............#.##.....#........#.#...#..#.#............#..#.
.......#.....#.#..............#..#..#........##.#.#...............#.....................#...#..#.##...........#.....#....#.#..#....
.......##..........#.#....#..#..#.......##.......#..................................#..#..........#............#....#......#.##....
.###.##.##........#.....#......#....#...................#.........#..................#...#..............#..#......#..........#..#..
.....##.........................#.....#.......#...#.....#.................##..#........#...................###.#......#..#....#....
..#........#........##......#..#.#..............#.........................#...###.#...#....##.#........#.#......#........#....##...
..........#.....#........#................##...........#...............###.....##...........#..#...#...#..##......#........#.#.....
.....#....#......................#.##.............#..#...#.#.............#............#..#..#.....#.......................#...###..
...................................................................................................................................""".split("\n")
package day3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import test.assert

class PartTwoSpec : FunSpec({
    test("provided example") {
        part2(
            """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...${'$'}.*....
            .664.598..
            """.trimIndent(),
        )
            .toList()
            .assert {
                shouldHaveSize(2)

                this[0].assert {
                    this[0].value shouldBe 467
                    this[1].value shouldBe 35
                    this.fold(1) { acc, part -> acc * part.value } shouldBe 16345
                }

                this[1].assert {
                    this[0].value shouldBe 755
                    this[1].value shouldBe 598
                    this.fold(1) { acc, part -> acc * part.value } shouldBe 451490
                }

                this.sumOf {
                    it[0].value * it[1].value
                } shouldBe 467835
            }
    }

    test("prompt") {
        part2(
            """
            .......12.......935............184.720...243........589.652..........435..........483.............6...........................904...........
            ......*.....968*.....${'$'}............*........=..348...*..........986....*...................459....*........422................#......%482....
            ....291............612....290..........903........699......218*.......376............890....*.838...81......*.....138.../194................
            ..............156......${'$'}..*...891.&731....%..89...................523..........699....+...227......*.......225....=...........388....*......
            ................*...189..591.*................*.......783.....107..-...54.287..${'$'}................533.../..............909........&.603.424...
            ...229*952.....938............470.555.......746...28.....+...*.........................................279..826..788*.......................
            ...................................*...............@.........867.-....102..845...542.779.....................*........182.166...511.........
            563.727.....282....237..171.......892...183.......................989....*..........*................${'$'}....709...8*974.=...%.....*.....873...
            ....#..........+...*.......*..........................&......129+......491...................877....715.......................270.......#...
            .................53.....781...&295....@773.336......547................................45......*.............=800.....*359..................
            ...342*468....&.....573....................*.................................%850............*..465................192.....*.......&115.....
            ............988.......*...731.............789.673....*256..............677..................621...........#....716......910..297........22..
            204&....69............905...=.....641.472.......#.524............127....*..714.........*62..........622..324..&.................*...........
            ..........*........................+....@.................812......*..955.....*.....257....../.................../..............545.........
            ........668....91..&.........840......+..............566.....+...66.........660..............469.................525...765...........25.....
            ...............${'$'}...666.979..*........952...122......%............................71......=39...../94.........................132......*.....
            ......@.................../.460..#.......=.=..........146..625........214.........#.278................667..........386.......-....936......
            ....643.......@..................974...464...........*.....*...........*.............%.....${'$'}...........=...=..%995...*......................
            ........./...577...-....3.../186.................*.995.....678.&.......882...559...........374.......&...554.........428.......725....*.....
            .......96........678....%.....................529..............374...........*......924........=277..606..................#...#......8.257..
            ...609....................397.......475...................651.......856......697.&.....&..=...................486........888................
            ............-................*..................756...399....*..42................866....287.....#......515...*......................137....
            .....285..947....#..........997......=.....665..*......*..420...*.....-..268*457.............=63..758.....+..623.............+../...........
            ..............458.....422.......338...827...+..462....797.....26....523..........*.880*.............................&.....934..157..........
            .......149........409....${'$'}................................................868.378......144..149............356.....872..............871.533.
            ....22...*..........${'$'}........7.......149....979......................826.&.....................@........-.....*275.....................*....
            ........518.773*.........10..${'$'}..........*........805..812.972......................123......*............98.........=........./609.682......
            .................5........./............349........${'$'}.....*..................786....*.......160..903...40.............209...............*....
            .......*.....................................497...........#.............../.....153.795............./.........&806..........839....419.337.
            78...582............675................145.........405....77..361............952.......*..../741....................624..527*...............
            ...................../../....=.....+....&.............*51.....*..........733*.........728.........173....834.....76.........................
            ................878....276..792.....372....................385..179.............@610.............................%........146=..............
            ..........522.....*...........................-....30....-........*.@................110=..+.......197.....643.................762......%...
            ......%....*...173.............420..407......261.........687.806.12..104.....914..........685.233.&.......*.....549...=...........*......591
            .....837..135.......313...579....%.=.....613................../..........729.........257#.....&.........430.399*.....157.........970........
            ...................*.....*.....*......@.....*............../....566........+.....................*906....................%..................
            ....459.78${'$'}.775.768..62...345.537......122.803.142*758...148...*....992................711....316.........#...............521.298*590..289..
            ....*.................#.........................................444............382.....*...@...............753.......927................/...
            .....592..735......+.............634.......652.....853....690................./.......874.846.35.....884.........182.-......................
            .419........*.839.157.......795...................*.......*...........928........................756....*64......*.....*19.....309..........
            .........716...*.......591....*....358${'$'}.#378.............623...............687.........-816......*............292...110....&....*......643..
            ..134...........910......*.941.......................................547=....*....................490....938+..............422.482..........
            ...*..331....${'$'}..........80.................#346....180...........737.........76.......992@...91......................../....................
            ...16....${'$'}.140.464*831.....933.917....303............*......%.....*....336........339.......*.............@..939....583....*564.........864.
            ..............................*........=...+54.....449......209.912.....+.....615..%.....605............960..*..........219.................
            .........@442.....730..................................413...........................26.....................944..336........188......./.....
            ...190............#...@...524.544....968*.............*........466...222...536...843.@..........=.....32...........${'$'}..........-.......410...
            ......*..80@..491....232..-......*.......16........402......27..*...*.....*...................480....*........&........894..................
            .....218.........*.............=..819......................*........857...896...........677........689........638...45*.....993.............
            ................754...........434.........622.338...........607....................&......&.%213...........................-................
            ........+.894......................681.......*.........484.........963.498...*..538.............................................346.........
            .....802.....*162....752...........................................*........520...........229.2.586..513..............25=.746........782*423
            ...............................@...307#.497....551..996..696....879...911................%......................277*........................
            ....*157.....137....#.........621.........*...#.....*...#............*............527......9........./..............844.....@224....304.....
            .541............*.649.............412.....744......560..............404.....240.......986*.@.......346.....@..........................+.....
            ......268....764.................%.......................902....856.......*....*..........................242.....842.....#.................
            ........&...............514..38..........+..=...........@..............715.142..587.......307.................731...*...954....878*.........
            ............................*.....349....76.92....612.....376.......................257...${'$'}...................../.968..............765......
            ........960*414........713.501......&............%.......*......*941............................#........415...........937%.................
            ....967............409..*......605......................375..771........599*884.................880.........*...127..${'$'}.................${'$'}513.
            .....*................*..171..*.....@.......507.895..................*.................636...........768...114....-..292.......-...223......
            ...807...977.......218.......753...47.......*......*..............507.90....../725.......*.........+...@.....................755......*.....
            ............*478.............................542....676...............................673........974.....@....*170....261..............134..
            800...............532............................15............%...445..102.............../510.........625.279..........-.....*.............
            .......................654.....850.405......................395.....-.......467....477...........973............../........191........398...
            .925...793...423*.........@..........................................................=.659..........*.....817.....230...........653..-......
            .......*.........52...........764${'$'}....273...................@........430....................................*...........669.....-.......71..
            .435....804..177....990.838.........#..-...475...297..337..360.........*....914.............................833.............................
            ....*.......*.........*...*.......281......&......*..+.............328..746......=215.......359....295.....................#481......868....
            ..967........936.689%.785..515...............*64.827........................761.........+....&.......+..............................*....637
            ....../.+265..............................562...............235........585..*...........793........=...838.147....284.902..301*330..........
            ....579.........................21%..327................481..*...469%..*.....297.704..............797.....*...........*.................#...
            ......................638............*...................*....81.......780.........*...../...282....................907.882.781.......797...
            ..........671....608.................295.................302......953............171..919.......*........................*...*......#.......
            ............*....*....251.....191........#............*..........................................999.....451....+....286.415.581....274.....
            ..245${'$'}.....217...649.-....................898......950..................495*497.......53*............@...........398..-.....................
            ...........................942.......323...............+.....623.........................804.......875........................#.............
            .....42..543.................*..320....*..918....314....145...........603......991${'$'}.921.......261......................762...187.....951*638
            .....*..#........53........374........756...........*.........-.......................*........../..217*550..............*..................
            ....217..........*................................743......703....368...${'$'}861..4*966.415..703................................*959........*344
            ...........626...31...602.................700..........696........*.....................*......396..........591.......*124..................
            ..135........@................................699.139.....*.662....46........=797......144.....#...*289......*.....840............-...102.44
            ................909.......180.............100.*....#...574..*............52...................................451............764.517....*...
            ........701*..........127*............117../...787...........67.....903..........273....*900................................=..........112..
            ............430............423.67.......*..............*572...........@...199.........94..........686.....679.....................921*......
            .542*119...............396....*.......938...........250......888..........*.....978...................25..../.........306.............780...
            ...............251........*.....................238......................340....+..............112....*........120...*....24................
            .223.....549......-..98..60..775..28*105...........*.436..951.599.................309*682.......*..937...158.....*....697.*......764..${'$'}.....
            .....788............#....................768.....266........*..%..............................779........*.......542.......148...*....529...
            ....*......310.............412.......23.+....289..........560............249+.204..606*................271...805.......394.......898........
            ....919.......&...867.......*........*......%.........592............166.........*.....460.........369..........*........*..................
            .........920.......*.....233.....732..500.....950.....*.......514...........110..961..................*309.....450..#...521.................
            .................753...............*............#...965..............................852...841....%........524.....981............653.......
            ...........858...........*..234..922........65..................991.........-839.800....*......869...836..${'$'}.............675..789...*....505.
            ..........*.............516...*..................774.....&.149.=.................*.......737.........*......402....%.......*....#..762......
            ........780.........4.........116.....................976..-...........%........791..................300.....%....338.471...................
            ...................*.................480*160..3..............*727.....363................................................................167
            ...........743.....721.......................*..........808...............942...........339.289.............${'$'}............416.....${'$'}..........
            ..955...................606*623.............718...503....*...................*245..........*........531.....686......250..../....275........
            .............@....................110...............*...309..#....&......210..........386.................%...........*........+........391.
            .....444.....743......519..691......*.......-824......+......759.617....*.......710..*.....814.........356.........464.......709............
            ......*..746......247.....*......596..999.............907.............296.-..../.......760.+.................${'$'}.890.......................669
            ...479.....*.........*.......561.....+..........*178......................977....266...*.....640..........607.....*.....%...........545.....
            ........395...=......361........*372.........655..........398...203..11................147..*......../.............196..499........*........
            ..561........646......................*898.......175.570.....${'$'}.....#...*..135..............633..314...871......898..........891...90.....780
            .......*91........405..............627..............*....736.........760.....*........=..........*...........%....*..........*..............
            ....722...........*......................................*.................744.698.367..-........767..........236.692.......308.............
            ...............740........./............906......*593...977.......645............*......167.............................................*...
            ........+...............123...................281....................*...543......461........................175.....................381.319
            .282...814......771*........920.......................@............473....*...............&....872...../401.....*......=......18............
            ....*.........%......993...*...........................256..223...........242....977.......293.-...............550.....435..................
            ....23.........960........307....${'$'}.....504.638*656...............&...................203.............33.${'$'}430..................731...........
            ................................885......*................398....763...........805.....=....338.......*......146*916..................513...
            ..20...............42....................828.............../...................*............${'$'}.........531............159*761......78........
            ......805-...-..........598...........#.............351........34.........682..516.534..............*........&..........................283.
            ..............664....../.......255..887.....258......%.........*.........*............*.....226..931.91......128............................
            ...557.938#.......75.....585..*...............*.194......#..686........786..........755.......&..........637..............988.......275.....
            ....*............%....35...*.141...........508.....*865.967..............................80*............./.....978....790*.....@...*........
            .662..................*..............@939...........................204........484....34....99.............@.................350.54.........
            ............358....832..=......................%......307.95........*......654...*......&.........734.....491...50...924.385................
            ............*............340................483.........-.*.......118..794*.....431...........783..*..............-......*.........&594.#...
            ..........338........=.............${'$'}.................*....94....................................*...546.....${'$'}.......187..593.768........282.
            ...............796.380.183....+.564..94.144.........138..............394.392.....971.......#928.447........275..57...*.......&..............
            ...........233...*.......%...40........*........................945.....*.........-.................%.............=.438...........*......906
            .....881.../...491...903..........918.....303......................*........578*...................807......597................681.539......
            ......*.................*.463.467*....246.......577.....198.....245.....967.....988.&.........759.......=...*.........-889..................
            ......462..978........664...%...........*.-731.../.....&....375.............#.......217........@........381.250...219......947..............
            ..........&..........................252.......%.............*..............258............427...137...............@........@....-175.......
            ....864...................461..................234.......69.222........*...........411....=............651...#..............................
            ....*......243...............*283...................777-..*..........92.761..581%.*.....................${'$'}.....258..867..876.................
            .916......%.........629.................911*238...........680...239................672.............137@...469.........*.......737...@.......
            ..............764....*........894/..289...........944..........#...........@....%........../876..........*.........687.........*....436.....
            ......442.255.....442..903.............*.....*493..../......................338..346...................927..............764.....536.........
            .........*.....*........*.....869*888.597.241..................11-....542#...........412*..................235..............................
            .804.329......344....195...94.......................................*....................880......44.622.........342.18...............417...
            ....*.....=................+.........76..328.....803.....658.....254.............327..........340......*.............@......................
            ...........254........../...........*...*...........*234...%..........20.....238...*..........*.........380......&......78.246%...598.......
            .96....990.........%..718...%....869.......596....*......................423.....433..93.....613....${'$'}.............905...=........*.....497..
            ...*....*........=.86.....499..............*...385.296...................*...........*...............523.${'$'}.....................529...${'$'}.*....
            ...780.685.....822....................560.35.............................529......780.....................453......................711..930.
            """.trimIndent(),
        )
            .toList()
            .assert {
                this.sumOf {
                    it[0].value * it[1].value
                } shouldBe 84584891
            }
    }
})

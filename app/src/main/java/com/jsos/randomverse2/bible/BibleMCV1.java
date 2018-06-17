package com.jsos.randomverse2.bible;

import com.jsos.randomverse2.models.Verse;

import java.util.ArrayList;

/**
 * Created by JHESE154 on 8/24/2016.
 * A class that holds the Bible verses to be shown on the user
 */
public class BibleMCV1 {
    public final static ArrayList<Verse> versesQuery = new ArrayList<>();
    public static final int VERSE_COUNT = 43;  // hardcoded for optimization. Fix this everytime
//    public static final double VERSION = 1.0;  // support for future updates

    public static ArrayList<Verse> generateQuery() {

        if (versesQuery.isEmpty()) {

            // Tungkol sa Kaligtasan
            versesQuery.add(new Verse(0, "Romans 3:23", "for all have sinned and fall short of the glory of God,", "Sapagkat ang lahat ay nagkasala, at walang sinumang nakaabot sa kaluwalhatian ng Diyos."));
            versesQuery.add(new Verse(1, "Romans 6:23", "For the wages of sin is death, but the gift of God is eternal life in Christ Jesus our Lord.", "Sapagkat kamatayan ang kabayaran ng kasalanan, ngunit ang libreng kaloob ng Diyos ay buhay na walang hanggan, sa pamamagitan ni Cristo Jesus na ating Panginoon."));
            versesQuery.add(new Verse(2, "Romans 5:8", "But God demonstrates his own love for us in this: While we were still sinners, Christ died for us.", "Ngunit ipinadama ng Diyos ang kanyang pag-ibig sa atin nang mamatay si Cristo para sa atin noong tayo'y makasalanan pa."));
            versesQuery.add(new Verse(3, "Ephesians 2:8", "For it is by grace you have been saved, through faith—and this not from yourselves, it is the gift of God—", "Sapagkat dahil sa kagandahang-loob ng Diyos kayo ay naligtas sa pamamagitan ng pananampalataya; at ang kaligtasang ito'y kaloob ng Diyos at hindi sa pamamagitan ng inyong sarili;"));
            versesQuery.add(new Verse(4, "Ephesians 2:9", "not by works, so that no one can boast.", "hindi ito bunga ng inyong mga gawa kaya't walang dapat ipagmalaki ang sinuman."));
            versesQuery.add(new Verse(5, "John 1:12", "Yet to all who received him, to those who believed in his name, he gave the right to become children of God—", "Subalit ang lahat ng tumanggap at sumampalataya sa kanya ay binigyan niya ng karapatang maging mga anak ng Diyos."));
            versesQuery.add(new Verse(6, "John 1:13", "children born not of natural descent, nor of human decision or a husband's will, but born of God.", "Sila ay naging mga anak ng Diyos, hindi dahil sa isinilang sila ayon sa kalikasan o sa kagustuhan o sa kagagawan ng tao, kundi ayon sa kalooban ng Diyos."));
            versesQuery.add(new Verse(7, "1 John 5:13", "I write these things to you who believe in the name of the Son of God so that you may know that you have eternal life.", "Isinusulat ko ito sa inyo upang malaman ninyo na kayong sumasampalataya sa Anak ng Diyos ay may buhay na walang hanggan."));

            // Paglagong Cristiano
            versesQuery.add(new Verse(8, "2 Peter 3:18", "But grow in the grace and knowledge of our Lord and Savior Jesus Christ. To him be glory both now and forever! Amen.", "Sa halip, patuloy kayong lumago sa kagandahang-loob ng ating Panginoon at Tagapagligtas na si Jesu-Cristo, at sa pagkakilala sa kanya. Sa kanya ang kaluwalhatian, ngayon at magpakailanman! Amen."));
            versesQuery.add(new Verse(9, "1 Peter 2:2", "Like newborn babies, crave pure spiritual milk, so that by it you may grow up in your salvation,", " Gaya ng sanggol, kayo'y manabik sa dalisay na gatas na espirituwal upang lumago kayo tungo sa kaligtasan,"));
            versesQuery.add(new Verse(10, "Joshua 1:8", "Do not let this Book of the Law depart from your mouth; meditate on it day and night, so that you may be careful to do everything written in it. Then you will be prosperous and successful.", "Huwag mong kaliligtaang basahin ang aklat ng kautusan. Pagbulay-bulayan mo iyon araw at gabi upang matupad mo ang lahat ng nakasaad doon. Sa ganoon, magiging masagana at matagumpay ang iyong pamumuhay."));
            versesQuery.add(new Verse(11, "John 15:7", "If you remain in me and my words remain in you, ask whatever you wish, and it will be done for you.", "Kung nananatili kayo sa akin at nananatili sa inyo ang aking mga salita, hingin ninyo ang anumang nais ninyo at matutupad iyon para sa inyo."));
            versesQuery.add(new Verse(12, "Philippians 4:6", "Do not be anxious about anything, but in everything, by prayer and petition, with thanksgiving, present your requests to God.", "Huwag kayong mabalisa tungkol sa anumang bagay. Sa halip, hingin ninyo sa Diyos ang lahat ng inyong kailangan sa pamamagitan ng panalanging may pasasalamat."));
            versesQuery.add(new Verse(13, "Philippians 4:7", "And the peace of God, which transcends all understanding, will guard your hearts and your minds in Christ Jesus.", "At ang kapayapaan ng Diyos na hindi kayang maunawaan ng tao ang siyang mag-iingat sa inyong puso at pag-iisip dahil sa inyong pakikipag-isa kay Cristo Jesus."));
            versesQuery.add(new Verse(14, "Hebrews 10:24", "And let us consider how we may spur one another on toward love and good deeds,", "Sikapin din nating gisingin ang damdamin ng bawat isa sa pagmamahal sa kapwa at sa paggawa ng mabuti."));
            versesQuery.add(new Verse(15, "Hebrews 10:25", "Let us not give up meeting together, as some are in the habit of doing, but let us encourage one another—and all the more as you see the Day approaching.", "Kaya't huwag kayong mawawalan ng pananampalataya sa Diyos, sapagkat dakila ang naghihintay na gantimpala para sa inyo."));

            // Bilang Alagad ni Jesus
            versesQuery.add(new Verse(16, "Matthew 6:33", "But seek first his kingdom and his righteousness, and all these things will be given to you as well.", "Ngunit higit sa lahat ay pagsikapan ninyo na kayo'y pagharian ng Diyos at mamuhay nang ayon sa kanyang kalooban, at ibibigay niya sa inyo ang lahat ng inyong pangangailangan."));
            versesQuery.add(new Verse(17, "Romans 12:2", "Do not conform any longer to the pattern of this world, but be transformed by the renewing of your mind. Then you will be able to test and approve what God's will is—his good, pleasing and perfect will.", "Huwag kayong makiayon sa takbo ng mundong ito. Mag-iba kayo sa pamamagitan ng pagbabago ng inyong pag-iisip upang maunawaan ninyo ang kalooban ng Diyos; kung ano ang mabuti, kalugud-lugod at ganap na kalooban niya."));
            versesQuery.add(new Verse(18, "Matthew 16:24", "Then Jesus said to his disciples, “Whoever wants to be my disciple must deny themselves and take up their cross and follow me.", " Sinabi ni Jesus sa kanyang mga alagad, “Sinumang nagnanais sumunod sa akin ay kailangang itakwil ang kanyang sarili, pasanin ang kanyang krus, at sumunod sa akin."));
            versesQuery.add(new Verse(19, "Matthew 16:25", "For whoever wants to save their life[a] will lose it, but whoever loses their life for me will find it.", "Ang naghahangad na magligtas ng kanyang buhay ay mawawalan nito; ngunit ang mawalan ng kanyang buhay alang-alang sa akin ay magkakamit nito."));
            versesQuery.add(new Verse(20, "1 Corinthians 15:58", "Therefore, my dear brothers and sisters, stand firm. Let nothing move you. Always give yourselves fully to the work of the Lord, because you know that your labor in the Lord is not in vain.", "Kaya nga, mga minamahal kong kapatid, magpakatatag kayo at huwag matinag. Maging masipag kayo palagi sa paglilingkod sa Panginoon, dahil alam ninyong hindi masasayang ang inyong pagpapagal para sa kanya."));
            versesQuery.add(new Verse(21, "Mark 10:45", "For even the Son of Man did not come to be served, but to serve, and to give his life as a ransom for many.", " Sapagkat ang Anak ng Tao ay naparito hindi upang paglingkuran kundi upang maglingkod at upang mag-alay ng kanyang buhay para sa ikatutubos ng marami."));
            versesQuery.add(new Verse(22, "Proverbs 3:9", "Honor the Lord with your wealth, with the firstfruits of all your crops;", "Parangalan mo si Yahweh sa pamamagitan ng iyong mga kayamanan, at mula sa iyong mga pinakamainam na ani, siya ay iyo ring handugan."));
            versesQuery.add(new Verse(23, "Proverbs 3:10", "then your barns will be filled to overflowing, and your vats will brim over with new wine.", "Sa gayon, kamalig mo ay lagi nang aapaw, sisidlan ng inumin ay hindi nga matutuyuan."));
            versesQuery.add(new Verse(24, "Acts 1:8", "But you will receive power when the Holy Spirit comes on you; and you will be my witnesses in Jerusalem, and in all Judea and Samaria, and to the ends of the earth.", "Subalit tatanggap kayo ng kapangyarihan pagbaba sa inyo ng Espiritu Santo, at kayo'y magiging mga saksi ko sa Jerusalem, sa buong Judea at sa Samaria, at hanggang sa dulo ng daigdig."));

            // Magtiwala sa Diyos
            versesQuery.add(new Verse(25, "1 Corinthians 2:12", "What we have received is not the spirit of the world, but the Spirit who is from God, so that we may understand what God has freely given us.", "Ang tinanggap natin ay hindi ang espiritu ng sanlibutan kundi ang Espiritu na mula sa Diyos upang maunawaan natin ang mga kaloob niya sa atin."));
            versesQuery.add(new Verse(26, "Philippians 4:13", "I can do everything through him who gives me strength.", "Ang lahat ng ito'y magagawa ko dahil sa lakas na kaloob sa akin ni Cristo."));
            versesQuery.add(new Verse(27, "Lamentations 3:22", "Because of the Lord's great love we are not consumed, for his compassions never fail.", "Pag-ibig mo, Yahweh, ay hindi nagmamaliw; kahabagan mo'y walang kapantay."));
            versesQuery.add(new Verse(28, "Lamentations 3:23", "They are new every morning; great is your faithfulness.", "Ito ay laging sariwa bawat umaga; katapatan mo'y napakadakila."));
            versesQuery.add(new Verse(29, "1 Peter 5:7", "Cast all your anxiety on him because he cares for you.", "Ipagkatiwala ninyo sa kanya ang inyong mga alalahanin sa buhay sapagkat siya ay nagmamalasakit sa inyo."));
            versesQuery.add(new Verse(30, "Philippians 4:19", "And my God will meet all your needs according to his glorious riches in Christ Jesus.", "At buhat sa hindi mauubos na kayamanan ng Diyos, ibibigay niya ang lahat ng inyong kailangan sa pamamagitan ni Cristo Jesus."));
            versesQuery.add(new Verse(31, "1 Corinthians 10:13", "No temptation has seized you except what is common to man. And God is faithful; he will not let you be tempted beyond what you can bear. But when you are tempted, he will also provide a way out so that you can stand up under it.", "Wala pang pagsubok na dumating sa inyo na hindi nararanasan ng lahat ng tao. Tapat ang Diyos, at hindi niya ipapahintulot na kayo'y subukin nang higit sa inyong makakaya. Sa halip, pagdating ng pagsubok, bibigyan niya kayo ng lakas upang mapagtagumpayan iyon."));

            // Tularan si Jesus
            versesQuery.add(new Verse(32, "Hebrews 12:2", "Let us fix our eyes on Jesus, the author and perfecter of our faith, who for the joy set before him endured the cross, scorning its shame, and sat down at the right hand of the throne of God.", "Ituon natin ang ating paningin kay Jesus na siyang pinagmumulan at kabuuan ng ating pananampalataya. Dahil sa kagalakang naghihintay sa kanya, hindi niya ikinahiya ang mamatay sa krus, at siya ngayo'y nakaupo sa kanan ng trono ng Diyos."));
            versesQuery.add(new Verse(33, "John 13:34", "A new command I give you: Love one another. As I have loved you, so you must love one another.", "Isang bagong utos ang ibinibigay ko sa inyo ngayon: magmahalan kayo! Kung paano ko kayo minahal, gayundin naman, magmahalan kayo."));
            versesQuery.add(new Verse(34, "John 13:35", "By this everyone will know that you are my disciples, if you love one another.", "Kung kayo'y may pagmamahal sa isa't isa, makikilala ng lahat na kayo'y mga alagad ko."));
            versesQuery.add(new Verse(35, "Philippians 2:3", "Do nothing out of selfish ambition or vain conceit. Rather, in humility value others above yourselves,", "Huwag kayong gumawa ng anuman dahil sa pansariling layunin o pagyayabang; sa halip, bilang tanda ng pagpapakumbaba, ituring ninyong higit ang iba kaysa inyong mga sarili."));
            versesQuery.add(new Verse(36, "Philippians 2:4", "not looking to your own interests but each of you to the interests of the others.", "Pagmalasakitan ninyo ang kapakanan ng iba, at hindi lamang ang sa inyong sarili"));
            versesQuery.add(new Verse(37, "Philippians 2:5", "In your relationships with one another, have the same mindset as Christ Jesus:", "Nawa'y magkaroon kayo ng kaisipan na tulad ng kay Cristo Jesus."));
            versesQuery.add(new Verse(38, "1 Peter 2:11", "Dear friends, I urge you, as foreigners and exiles, to abstain from sinful desires, which wage war against your soul.", "Mga minamahal, nakikiusap ako sa inyo, bilang mga dayuhan at pansamantalang naninirahan lamang sa daigdig na ito, talikuran na ninyo ang mga pagnanasa ng laman na nakikidigma sa inyong mga sarili."));
            versesQuery.add(new Verse(39, "Acts 24:16", "So I strive always to keep my conscience clear before God and man.", "Kaya't pinagsisikapan kong laging maging malinis ang aking budhi sa harap ng Diyos at ng tao."));
            versesQuery.add(new Verse(40, "Galatians 6:9", "Let us not become weary in doing good, for at the proper time we will reap a harvest if we do not give up.", " Kaya't huwag tayong mapagod sa paggawa ng mabuti sapagkat pagdating ng takdang panahon tayo ay aani kung hindi tayo susuko."));
            versesQuery.add(new Verse(41, "Galatians 6:10", "Therefore, as we have opportunity, let us do good to all people, especially to those who belong to the family of believers.", "Kaya nga, basta may pagkakataon ay gumawa tayo ng mabuti sa lahat ng tao, lalo na sa mga kapatid natin sa pananampalataya."));
            versesQuery.add(new Verse(42, "Romans 12:1", "Therefore, I urge you, brothers, in view of God's mercy, to offer your bodies as living sacrifices, holy and pleasing to God—this is your spiritual act of worship.", "Kaya nga, mga kapatid, alang-alang sa masaganang habag ng Diyos sa atin, ako'y nakikiusap na ialay ninyo ang inyong sarili bilang isang handog na buháy, banal at kalugud-lugod sa Diyos. Ito ang karapat-dapat na pagsamba ninyo sa Diyos. "));
        }
        return versesQuery;
    }
}

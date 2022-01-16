package com.johan.hewanpediabyjo;

import android.content.Context;

import com.johan.hewanpediabyjo.model.Hantu;
import com.johan.hewanpediabyjo.model.Hewan;
import com.johan.hewanpediabyjo.model.Kucing;
import com.johan.hewanpediabyjo.model.Ular;
import com.johan.hewanpediabyjo.model.Serangga;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing(ctx.getString(R.string.br), ctx.getString(R.string.in),
                ctx.getString(R.string.we), R.drawable.british_shorthair_biru));
        kucings.add(new Kucing(ctx.getString(R.string.mi), ctx.getString(R.string.am),
                ctx.getString(R.string.sd), R.drawable.kucing_mine_coon));
        kucings.add(new Kucing(ctx.getString(R.string.fa), ctx.getString(R.string.tha),
                ctx.getString(R.string.ga), R.drawable.kucing_siam));
        return kucings;
    }

    private static List<Hantu> initDataHantu(Context ctx) {
        List<Hantu> hantus = new ArrayList<>();
        hantus.add(new Hantu(ctx.getString(R.string.de), ctx.getString(R.string.wer),
                ctx.getString(R.string.ce), R.drawable.harga_burung_hantu_celepuk));
        hantus.add(new Hantu(ctx.getString(R.string.vaa), ctx.getString(R.string.yo),
                ctx.getString(R.string.tab), R.drawable.snowy_owl_by_cycoze));
        hantus.add(new Hantu(ctx.getString(R.string.hy), ctx.getString(R.string.tyu),
                ctx.getString(R.string.po), R.drawable.eurasian_eagle_owl_pat_eisenberger));
        return hantus;
    }

    private static List<Ular> initDataUlar(Context ctx) {
        List<Ular> ulars = new ArrayList<>();
        ulars.add(new Ular(ctx.getString(R.string.wede), ctx.getString(R.string.za),
                ctx.getString(R.string.yutb), R.drawable.kobra));
        ulars.add(new Ular(ctx.getString(R.string.oi), ctx.getString(R.string.outy),
                ctx.getString(R.string.poe), R.drawable.piton));
        ulars.add(new Ular(ctx.getString(R.string.qwrt), ctx.getString(R.string.qwsa),
                ctx.getString(R.string.qwdr), R.drawable.ular_hijau));
        return ulars;
    }

    private static List<Serangga> initDataSerangga(Context ctx) {
        List<Serangga> seranggas = new ArrayList<>();
        seranggas.add(new Serangga(ctx.getString(R.string.qwsz), ctx.getString(R.string.qwda),
                ctx.getString(R.string.qwcr), R.drawable.serangga1));
        seranggas.add(new Serangga(ctx.getString(R.string.qwmu), ctx.getString(R.string.oiv),
                ctx.getString(R.string.pmn), R.drawable.serangga2));
        seranggas.add(new Serangga(ctx.getString(R.string.bnm), ctx.getString(R.string.vfr),
                ctx.getString(R.string.crf), R.drawable.serangga3));
        return seranggas;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataHantu(ctx));
        hewans.addAll(initDataUlar(ctx));
        hewans.addAll(initDataSerangga(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}

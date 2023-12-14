package com.legends.edumia.dynamictrees.cell;

import com.legends.edumia.Edumia;
import com.legends.edumia.dynamictrees.api.cell.Cell;
import com.legends.edumia.dynamictrees.api.cell.CellKit;
import com.legends.edumia.dynamictrees.api.cell.CellNull;
import com.legends.edumia.dynamictrees.api.cell.CellSolver;
import com.legends.edumia.dynamictrees.util.SimpleVoxmap;

public class CellKits {

    public static final CellKit DECIDUOUS = new CellKit(Edumia.location("deciduous")) {

        @Override
        public Cell getCellForLeaves(int distance) {
            return null;
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return null;
        }

        @Override
        public CellSolver getCellSolver() {
            return null;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return null;
        }

        @Override
        public int getDefaultHydration() {
            return 0;
        }

        private final Cell[] normalCells = {
                CellNull.NULL_CELL,
                new NormalCell(1),
                new NormalCell(2),
                new NormalCell(3),
                new NormalCell(4),
                new NormalCell(5),
                new NormalCell(6),
                new NormalCell(7)
        };
    };
}

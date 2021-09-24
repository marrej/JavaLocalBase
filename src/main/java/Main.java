import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    List<Deque<Integer>> gameLayout;
    public String testMethod() {
        return "method";
    }


    public List<Deque<Integer>> solveHanoiTowers(List<Deque<Integer>> baselayout) throws Exception {
        this.gameLayout = baselayout;
        var lengthOfTheHanoiTower = baselayout.get(0).getLast();
        var isEvenAmountOfBlocksOnLastTower = lengthOfTheHanoiTower % 2 == 0;
        generatePartialHanoiTowersUpTo(lengthOfTheHanoiTower, isEvenAmountOfBlocksOnLastTower);
        return this.gameLayout;
    }

    private void generatePartialHanoiTowersUpTo(Integer lengthOfTheHanoiTower, boolean isEvenAmountOfBlocksOnLastTower) throws Exception {
        for (var i = 1; i <= lengthOfTheHanoiTower; i++) {
            var isTowerThatWeAreBuildingEven = i %2 == 0;
            var isTowerGoingToBeOnLastSlot = isEvenAmountOfBlocksOnLastTower == isTowerThatWeAreBuildingEven;
            this.buildTowerOfSize(i,getSlotPositionForSignificantTower(isTowerGoingToBeOnLastSlot));
        }
    }

    public void buildTowerOfSize(Integer size, Integer inheritedSlotToBuildOn) throws Exception {

            var slotTopPullFrom = findSlotContaining(size);
            if (!slotTopPullFrom.isEmpty()) {
                moveBlockToNewSlot(inheritedSlotToBuildOn, slotTopPullFrom);
                moveAllPredecessorTowers(size, inheritedSlotToBuildOn);
            } else {
                throw new Exception();
            }
    }

    private void moveAllPredecessorTowers(Integer size, Integer slotToBuildOn) throws Exception {
        for (var i = 1; i < size; i ++) {
            var deepSlotToBuildOn = getTheNextSlotToBuildSubtower(size, slotToBuildOn, i);
            this.buildTowerOfSize(i,deepSlotToBuildOn);
        }
    }

    private void moveBlockToNewSlot(Integer slotToBuildOn, Optional<Deque<Integer>> slotTopPullFrom) throws Exception {
        var block = slotTopPullFrom.get().pop();
        Deque<Integer> slotToPushTo = this.gameLayout.get(slotToBuildOn);
        if (slotToPushTo.size() != 0 && slotToPushTo.getFirst() < block) {throw new Exception();}
        slotToPushTo.addFirst(block);
    }

    private Integer getTheNextSlotToBuildSubtower(Integer towerBaseBlock, Integer slotToBuildOn, int actualBlock) {
        var canActualBlockBePlacedOnTowerBase = (actualBlock % 2 == 0) == (towerBaseBlock % 2 == 0);
        if (canActualBlockBePlacedOnTowerBase) {
            var actualSlotForTheBlock = this.findSlotPositionContaining(actualBlock);
            return this.getPositionWhereWeCanBuild(actualSlotForTheBlock, slotToBuildOn);
        } else {
            return slotToBuildOn;
        }
    }

    private Integer findSlotPositionContaining(Integer block) {
        for (var i=0;i<this.gameLayout.size();i++) {
            var gameSlot = this.gameLayout.get(i);
            if (gameSlot.size() != 0 && gameSlot.getFirst() == block) return i;
        }
        return 0;
    }

    public Integer getPositionWhereWeCanBuild(Integer actualNumberSlot, Integer expectedTowerSlot) {
        List<Integer> positions = Arrays.asList(0,1,2);
        var positionToPlace = positions.stream().filter(position -> position != actualNumberSlot && position != expectedTowerSlot).findFirst();
        return positionToPlace.get();
    }

    private Optional<Deque<Integer>> findSlotContaining(int i) {
        Predicate<Deque<Integer>> isSlotContainingBlock = (Deque<Integer> slot) -> slot.size() > 0 && slot.getFirst().equals(i);
        return this.gameLayout.stream()
                .filter(isSlotContainingBlock)
                .findFirst();
    }

    private Integer getSlotPositionForSignificantTower(boolean isTowerGoingToBeOnLastSlot) {
        Integer slotPosition;
        if (isTowerGoingToBeOnLastSlot) {
            slotPosition = 2;
        } else {
            slotPosition = 1;
        }
        return slotPosition;
    }
}
